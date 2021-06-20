package com.luizcasagrande.apipedido.framework;

import com.luizcasagrande.apipedido.framework.annotation.CompleteField;
import com.luizcasagrande.apipedido.framework.exception.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.validation.Validation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.luizcasagrande.apipedido.util.SqlUtil.getSqlBase;
import static com.luizcasagrande.apipedido.util.SqlUtil.montaWhereDinamico;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNumeric;

@Component
public abstract class CrudServiceImpl<T, ID, Y> implements CrudService<T, ID, Y> {

    @Autowired
    protected EntityManager entityManager;

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public T findOne(ID id) {
        T entity = getRepository().findById(id)
                .orElseThrow(() -> new NoResultException("Não encontrado registro com id " + id));
        postFindOne(entity);
        return entity;
    }

    public void postFindOne(T entity) {
    }

    @Override
    public T save(T entity) {
        validate(entity);
        preSave(entity);
        return getRepository().save(entity);
    }

    public void validate(T entity) {
        var violations = Validation.buildDefaultValidatorFactory().getValidator().validate(entity);

        violations.stream().findAny().ifPresent(violation -> {
            throw new ExpectedException(String.format("Erro no campo '%s', %s",
                    violation.getPropertyPath(), violation.getMessage()));
        });
    }

    public void preSave(T entity) {
    }

    @Override
    public void delete(ID id) {
        if (!getRepository().existsById(id)) {
            throw new NoResultException("Não encontrado registro com id " + id);
        }
        getRepository().deleteById(id);
    }

    @Override
    public List<T> complete(String query) {
        var clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        var sql = new StringBuilder(getSqlBase(clazz.getSimpleName()));
        if (isNumeric(query)) {
            sql.append(montaWhereDinamico(query, null));

        } else if (!isEmpty(query)) {
            var fields = Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(CompleteField.class))
                    .map(Field::getName).collect(Collectors.toList());
            sql.append(montaWhereDinamico(query, fields));
        }
        return entityManager.createQuery(sql.toString(), clazz)
                .setMaxResults(20).getResultList();
    }
}
