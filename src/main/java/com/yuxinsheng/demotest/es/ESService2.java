package com.yuxinsheng.demotest.es;

public class ESService2 {
    public static void main(String[] args) {
        //    public static void search() {
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        //查询字段设置
//        sourceBuilder.fetchSource(new String[]{"user_id", "user_name", "user_age"}, null);
//
//        //分页设置
////        sourceBuilder.from(1);
////        sourceBuilder.size(3);
//
//
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        boolQueryBuilder.should().add(new MatchQueryBuilder("user_name", "张三"));
//        boolQueryBuilder.should().add(new MatchQueryBuilder("user_name", "李四"));
//
//        //条件查询
////        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("user_name", "张三"));
////        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("user_name", "李四"));
//
//        //范围查询
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("user_age");
//        rangeQueryBuilder.gte(19);
//        rangeQueryBuilder.lte(20);
//        boolQueryBuilder.must(rangeQueryBuilder);
//
//
//        sourceBuilder.query(boolQueryBuilder);
//
//
//        //排序设置
////        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
////        sourceBuilder.sort(new FieldSortBuilder("user_age").order(SortOrder.DESC));
//
//        //构建searchRequest
//        SearchRequest request = new SearchRequest("user_index");//设置index
//        //查询条件
//        request.source(sourceBuilder);
//
//        try {
//            //查询
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            List<ESUser> users = Lists.newArrayList();
//            Gson gson = new Gson();
//            hits.forEach(hit -> {
//                Map source = hit.getSourceAsMap();
//                ESUser user = gson.fromJson(gson.toJson(source), ESUser.class);
//                user.set_id(hit.getId());
//                users.add(user);
//            });
//            System.out.println(new Gson().toJson(users));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        search();
//    }
    }
}
