package com.practice.pattern.command;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:02 下午
 */
//具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}