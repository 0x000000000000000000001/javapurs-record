    // Port of Record/Builder.js. Records are maps (the typed-record classes
    // extend AbstractMap, so the map operations keep working).
    public static Object copyRecord = (java.util.function.Function<Object, Object>) (rec) ->
        new java.util.LinkedHashMap<>((java.util.Map<String, Object>) rec);

    public static Object unsafeInsert = (java.util.function.Function<Object, Object>) (l) ->
        (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Function<Object, Object>) (rec) -> {
            ((java.util.Map<String, Object>) rec).put((String) l, a);
            return rec;
        };

    public static Object unsafeModify = (java.util.function.Function<Object, Object>) (l) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (rec) -> {
            java.util.Map<String, Object> map = (java.util.Map<String, Object>) rec;
            map.put((String) l, ((java.util.function.Function<Object, Object>) f).apply(map.get((String) l)));
            return rec;
        };

    public static Object unsafeDelete = (java.util.function.Function<Object, Object>) (l) ->
        (java.util.function.Function<Object, Object>) (rec) -> {
            ((java.util.Map<String, Object>) rec).remove((String) l);
            return rec;
        };

    public static Object unsafeRename = (java.util.function.Function<Object, Object>) (l1) ->
        (java.util.function.Function<Object, Object>) (l2) ->
        (java.util.function.Function<Object, Object>) (rec) -> {
            java.util.Map<String, Object> map = (java.util.Map<String, Object>) rec;
            map.put((String) l2, map.remove((String) l1));
            return rec;
        };
