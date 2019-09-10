package com.yuxinsheng.demotest.test.test2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/29 18:25
 */
public class Test5 {


    public static <T> List<List<T>> averageAssign(List<T> source, int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n;  //(先计算出余数)
        int number=source.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }


    public static <T>List<List<T>> splitList(List<T> targe, int size) {
        List<List<T>> listArr = Lists.newArrayList();
        //获取被拆分的数组个数
        int arrSize = targe.size()%size==0?targe.size()/size:targe.size()/size+1;
        for(int i=0;i<arrSize;i++) {
            List<T>	sub = new ArrayList<T>();
            //把指定索引数据放入到list中
            for(int j=i*size;j<=size*(i+1)-1;j++) {
                if(j<=targe.size()-1) {
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }


    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        List<List<Integer>> lists = splitList(list,3);
        System.out.println(lists);
    }

}
