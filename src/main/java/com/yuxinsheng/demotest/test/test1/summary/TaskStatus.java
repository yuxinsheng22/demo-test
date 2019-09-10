package com.yuxinsheng.demotest.test.test1.summary;

/**
 * @author yuxinsheng
 * @date 2018/10/17 14:06
 */
public enum TaskStatus {

    未开始(0),
    执行中(1),
    暂停(2),
    已完成(3),
    删除(4),
    提前结束(5);

    private int index;

//    public int getIndex() {
//        return index;
//    }

    TaskStatus(int index) {
        this.index = index;
    }

    public static TaskStatus getEnum(int index) {
        TaskStatus[] taskStatuses = TaskStatus.values();
        for (TaskStatus taskStatus : taskStatuses) {
            if (taskStatus.index == index) {
                return taskStatus;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //获取未开始的索引:0
        int index = TaskStatus.未开始.index;
        System.out.println(index);
        //根据索引0取出枚举值
        TaskStatus taskStatus = TaskStatus.getEnum(0);
        System.out.println(taskStatus.name());
    }


}
