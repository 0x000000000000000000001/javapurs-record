    // Port of Record/Unsafe/Union.js: r2 first, then r1 overrides its keys.
    public static Object unsafeUnionFn = (java.util.function.Function<Object, Object>) (r1) ->
        (java.util.function.Function<Object, Object>) (r2) -> {
            java.util.Map<String, Object> copy = new java.util.LinkedHashMap<>((java.util.Map<String, Object>) r2);
            copy.putAll((java.util.Map<String, Object>) r1);
            return copy;
        };
