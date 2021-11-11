package com.practice.pattern.command;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:03 下午
 */
//调用者
class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}