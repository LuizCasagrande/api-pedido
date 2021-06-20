package com.luizcasagrande.apipedido.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class SqlUtil {

    public static String getSqlFile(String fileName) {
        try {
            var inputStream = SqlUtil.class.getClassLoader().getResourceAsStream(fileName);
            return IOUtils.toString(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSqlBase(String tableName) {
        return String.format(" select t from %s t where 1 = 1 ", tableName);
    }

    public static String montaWhereDinamico(String query, List<String> columnNames) {
        var result = new StringBuilder();

        if (columnNames == null) {
            result.append(String.format(" and id = %s ", query));
        } else {
            for (int i = 0; i < columnNames.size(); i++) {
                result.append(i == 0 ? " and " : " or ")
                        .append(String.format(" lower(%s) like lower(%s) ",
                                columnNames.get(i), "'%" + query + "%'"));
            }
        }
        return result.toString();
    }
}
