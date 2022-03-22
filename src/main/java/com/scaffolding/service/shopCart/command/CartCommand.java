package com.scaffolding.service.shopCart.command;

import com.whhim.hxh.service.shopCart.enums.OperationCartEnum;

public interface CartCommand {

    void execute(OperationCartEnum operationCartEnum);
}