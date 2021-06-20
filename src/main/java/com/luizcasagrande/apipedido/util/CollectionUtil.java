package com.luizcasagrande.apipedido.util;

import java.util.Collection;

public class CollectionUtil {

    public static void lazyLoad(Collection<?> collection) {
        if (collection != null) {
            collection.size();
        }
    }

    public static void lazyLoad(Collection<?> ...collections) {
        for (Collection<?> collection : collections) {
            lazyLoad(collection);
        }
    }
}
