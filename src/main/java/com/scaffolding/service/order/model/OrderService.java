package com.scaffolding.service.order.model;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.config.executor.AsyncThreadPoolExecutor;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.controller.order.req.OrderDetailReq;
import com.whhim.hxh.controller.order.req.OrderListReq;
import com.whhim.hxh.controller.order.req.confirm.OrderCommitReq;
import com.whhim.hxh.controller.order.req.confirm.OrderConfirmReq;
import com.whhim.hxh.controller.order.req.confirm.ProductConfirmReq;
import com.whhim.hxh.controller.order.vo.*;
import com.whhim.hxh.controller.order.vo.confirm.ConfirmOrderVO;
import com.whhim.hxh.controller.order.vo.confirm.StoreProductVO;
import com.whhim.hxh.controller.order.vo.detail.*;
import com.whhim.hxh.controller.product.vo.ProductVO;
import com.whhim.hxh.controller.store.vo.StoreVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.mapper.HxhDictionaryMapper;
import com.whhim.hxh.mapper.HxhOrderDetailMapper;
import com.whhim.hxh.mapper.HxhOrderMapper;
import com.whhim.hxh.mapper.HxhUserAddressMapper;
import com.whhim.hxh.payment.enums.PayPatternEnums;
import com.whhim.hxh.pojo.entity.HxhMaterialEntity;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import com.whhim.hxh.pojo.entity.HxhOrderEntity;
import com.whhim.hxh.pojo.entity.HxhUserAddressEntity;
import com.whhim.hxh.pojo.vo.ReceiverVO;
import com.whhim.hxh.service.order.CommonOrderService;
import com.whhim.hxh.service.order.constant.OrderBtnConstant;
import com.whhim.hxh.service.order.constant.OrderMessageConstant;
import com.whhim.hxh.service.order.constant.OrderTargetConstant;
import com.whhim.hxh.service.order.dto.OrderParamDTO;
import com.whhim.hxh.service.order.enums.*;
import com.whhim.hxh.service.order.model.template.AbstractOrderTemplate;
import com.whhim.hxh.service.product.CommonProductService;
import com.whhim.hxh.service.product.constant.ProductMessageConstant;
import com.whhim.hxh.service.shopCart.handler.ShopCartHandler;
import com.whhim.hxh.util.DateUtils;
import com.whhim.hxh.util.OrderUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 11:40 上午
 */
@Service
public class OrderService extends AbstractOrderTemplate implements IOrderStrategy {

    @Autowired
    protected CommonOrderService commonOrderService;
    @Autowired
    protected CommonProductService commonProductService;

    @Autowired
    protected HxhDictionaryMapper hxhDictionaryMapper;
    @Autowired
    protected HxhOrderMapper hxhOrderMapper;
    @Autowired
    protected HxhOrderDetailMapper hxhOrderDetailMapper;
    @Autowired
    protected HxhUserAddressMapper hxhUserAddressMapper;

    @Autowired
    protected ShopCartHandler shopCartHandler;

    @Autowired
    @Qualifier(value = AsyncThreadPoolExecutor.COMMON_THREAD_POOL_EXECUTOR)
    protected ThreadPoolTaskExecutor executor;

    protected final OrderParamDTO getOrderItemByOrderNo(String orderNo) {
        // 订单主表信息
        HxhOrderEntity orderInfo = commonOrderService.getOrder(orderNo);
        // 订单系表信息
        List<HxhOrderDetailEntity> orderDetailList = commonOrderService.getOrderDetail(orderNo);
        List<String> skuList = orderDetailList.stream().map(HxhOrderDetailEntity::getSkuCode).collect(Collectors.toList());
        List<HxhMaterialEntity> hxhMaterialEntities = commonProductService.listMaterialBySkuList(skuList);
        OrderParamDTO orderParamDTO = new OrderParamDTO();
        orderParamDTO.setOrderInfo(orderInfo);
        orderParamDTO.setOrderDetailList(orderDetailList);
        orderParamDTO.setMaterialList(hxhMaterialEntities);
        return orderParamDTO;
    }

    protected final OrderParamDTO listOrderItemByOrderNoList(List<String> orderNoList) {
        // 订单主表信息
        List<HxhOrderEntity> orderList = commonOrderService.listOrder(orderNoList);
        // 订单系表信息
        List<HxhOrderDetailEntity> orderDetailList = commonOrderService.listOrderDetail(orderNoList);
        List<String> skuList = orderDetailList.stream().map(HxhOrderDetailEntity::getSkuCode).collect(Collectors.toList());
        List<HxhMaterialEntity> hxhMaterialEntities = commonProductService.listMaterialBySkuList(skuList);
        OrderParamDTO orderParamDTO = new OrderParamDTO();
        orderParamDTO.setOrderList(orderList);
        orderParamDTO.setOrderDetailList(orderDetailList);
        orderParamDTO.setMaterialList(hxhMaterialEntities);
        return orderParamDTO;
    }

    /**
     * 查询订单状态总数
     */
    Long countListOrderItemInfo(OrderListReq orderListReq) {
        return 0L;
    }

    @Override
    public List<OrderTargetVO> queryOrderTarget() {
        List<OrderTargetVO> targetList = new ArrayList<>();
        targetList.add(OrderTargetConstant.ALL);
        targetList.add(OrderTargetConstant.WAIT_PAY);
        targetList.add(OrderTargetConstant.WAIT_DELIVERY);
        targetList.add(OrderTargetConstant.WAIT_RECEIVE);
        targetList.add(OrderTargetConstant.RECEIVED);
        return targetList.stream().sorted(Comparator.comparing(OrderTargetVO::getSort)).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemVO> listOrderInfo(OrderListReq orderListReq) {
        return new ArrayList<>();
    }

    @Override
    public Integer countListOrder(OrderListReq orderListReq) {
        return 0;
    }

    @Override
    public OrderDetailVO queryOrderDetail(OrderDetailReq orderDetailReq) {
        return new OrderDetailVO();
    }

    /**
     * 确认订单
     */
    @Override
    public ConfirmOrderVO confirmOrder(OrderConfirmReq orderConfirmReq) {
        UserInfo userInfo = Authentication.getUserInfo();
        Long id = userInfo.getId();
        ConfirmOrderVO confirmOrderVO = new ConfirmOrderVO();
        // 地址信息
        HxhUserAddressEntity hxhUserAddressEntity = hxhUserAddressMapper.selectOne(new QueryWrapper<HxhUserAddressEntity>().lambda()
                .eq(HxhUserAddressEntity::getUserId, id)
                .eq(HxhUserAddressEntity::getIfDefault, 1));
        if (Objects.nonNull(hxhUserAddressEntity)) {
            // 地址id
            ReceivedAddressVO receivedAddressVO = new ReceivedAddressVO();
            receivedAddressVO.setId(hxhUserAddressEntity.getId());
            receivedAddressVO.setContacts(hxhUserAddressEntity.getContacts());
            receivedAddressVO.setTelephone(hxhUserAddressEntity.getTelephone());
            receivedAddressVO.setProvinceCode(hxhUserAddressEntity.getProvinceCode());
            receivedAddressVO.setProvinceName(hxhUserAddressEntity.getProvinceName());
            receivedAddressVO.setCityCode(hxhUserAddressEntity.getCityCode());
            receivedAddressVO.setCityName(hxhUserAddressEntity.getCityName());
            receivedAddressVO.setCountyCode(hxhUserAddressEntity.getCountyCode());
            receivedAddressVO.setCountyName(hxhUserAddressEntity.getCountyName());
            receivedAddressVO.setMapPosition(hxhUserAddressEntity.getMapPosition());
            receivedAddressVO.setAddress(hxhUserAddressEntity.getAddress());
            receivedAddressVO.setIfDefault(hxhUserAddressEntity.getIfDefault());
            confirmOrderVO.setReceivedAddress(receivedAddressVO);
        }
        Integer confirmWay = orderConfirmReq.getConfirmWay();
        ConfirmWayEnum confirmWayEnum = ConfirmWayEnum.getEnumByType(confirmWay);
        switch (confirmWayEnum) {
            case PRODUCT_CONFIRM:
                // 商详下单 到确认订单页
                ProductConfirmReq productConfirmReq = orderConfirmReq.getProductConfirm();
                String skuCode = productConfirmReq.getSkuCode();
                HxhMaterialEntity materialEntity = commonProductService.getMaterialBySku(skuCode);

                // 店铺及其店铺下商品 List
                List<StoreProductVO> storeProductList = new ArrayList<>();

                // 店铺及其店铺下商品
                StoreProductVO storeProductVO = new StoreProductVO();
                // 店铺
                StoreVO wahaha = new StoreVO();
                wahaha.setId(GlobalConstant.WAHAHA_STORE_ID);
                wahaha.setStoreName(GlobalConstant.WAHAHA_STORE);
                // 商品列表
                List<ProductVO> productList = new ArrayList<>();
                ProductVO productVO = new ProductVO();
                productVO.setBuyCount(productConfirmReq.getBuyNum());
                productVO.setMinPurchase(materialEntity.getMinPurchase());
                productVO.setMaxPurchase(materialEntity.getMaxPurchase());
                productVO.setOnShelf(materialEntity.getOnShelf());
                productVO.setId(materialEntity.getId());
                productVO.setSpuCode(materialEntity.getSpuCode());
                productVO.setSkuCode(materialEntity.getSkuCode());
                productVO.setMaterialCode(materialEntity.getMaterialCode());
                productVO.setMaterial(materialEntity.getMaterial());
                productVO.setUnit(materialEntity.getUnit());
                productVO.setPicPath(materialEntity.getPicPath());
                productVO.setMilliliter(materialEntity.getMilliliter());
                productVO.setTaste(materialEntity.getTaste());
                productVO.setSpecification(materialEntity.getSpecification());
                productVO.setUnitPrice(materialEntity.getUnitPrice());
                productVO.setMarkPrice(materialEntity.getMarkPrice());
                productVO.setStoreId(materialEntity.getStoreId());
                // 添加商品
                productList.add(productVO);
                // 设置店铺
                storeProductVO.setStore(wahaha);
                // 设置订单商品
                storeProductVO.setProductList(productList);
                storeProductList.add(storeProductVO);
                // 设置 店家商品List
                confirmOrderVO.setStoreProductList(storeProductList);
                break;
            case SHOPCART_CONFIRM:
                shopCartHandler.confirmOrder(orderConfirmReq, confirmOrderVO);
                break;
            default:
                break;
        }

        confirmOrderVO.setPayPattern(PayPatternEnums.WECHAT.getPayPattern());
        return confirmOrderVO;
    }

    /**
     * 提交订单 父类创建订单号 以及插入 订单主系表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderCommitVO commitOrder(OrderCommitReq orderCommitReq) {
        // TODO PreProcess 添加 1、风控 2、预处理 3、校验地址/其他信息等 handler 执行链路 进行校验
        return new OrderCommitVO();
    }


    @Override
    public void assemblyOrderStore(OrderItemVO orderItemVO, OrderParamDTO orderParamDTO) {

    }

    @Override
    public void assemblyOrderDetailLabel(OrderDetailVO orderDetailVO) {
        OrderDetailLabelVO orderDetailLabel = new OrderDetailLabelVO();
        HxhOrderEntity orderInfo = orderDetailVO.getOrderItem().getOrderParamDTO().getOrderInfo();
        Integer orderStatus = orderInfo.getOrderStatus();
        OrderStatusEnum orderStatusEnums = OrderStatusEnum.getEnumByType(orderStatus);
        switch (orderStatusEnums) {
            case WAIT_PAY:
            case WAIT_SEND:
            case WAIT_ACCEPT:
            case RECEIVED:
            case COMPLETED:
                orderDetailLabel.setLabelType(orderStatusEnums.getType());
                orderDetailLabel.setLabelName(orderStatusEnums.getTypeName());
                break;
            case CLOSE_DEAL:
                orderDetailLabel.setLabelType(orderStatusEnums.getType());
                orderDetailLabel.setLabelName(orderStatusEnums.getTypeName());
                orderDetailLabel.setCloseReason("");
                break;
            default:
                break;
        }

        long countdownTime = DateUtils.LocalDateTime2TimeStamp(DateUtils.addHours(orderInfo.getCreateTime(), 1)) - System.currentTimeMillis() - 1000;
        orderDetailLabel.setCountDownTime(countdownTime > 0 ? countdownTime : -1);
        orderDetailVO.setOrderDetailLabel(orderDetailLabel);

    }

    @Override
    public void assemblyOrderReceiver(OrderDetailVO orderDetailVO) {
        HxhOrderEntity orderInfo = orderDetailVO.getOrderItem().getOrderParamDTO().getOrderInfo();
        ReceiverVO receiverVO = new ReceiverVO();
        receiverVO.setReceiver(orderInfo.getContacts());
        receiverVO.setPhone(orderInfo.getTelephone());
        receiverVO.setAddress(orderInfo.getAddress());
        orderDetailVO.setReceiver(receiverVO);
    }

    @Override
    public void assemblyConfirmOrderMoney(ConfirmOrderVO confirmOrderVO) {
        // 总付款金额
        BigDecimal paymentAmount = BigDecimal.ZERO;
        List<StoreProductVO> storeProductList = confirmOrderVO.getStoreProductList();

        for (StoreProductVO storeProductVO : storeProductList) {
            StoreVO store = storeProductVO.getStore();
            List<ProductVO> productList = storeProductVO.getProductList();
            for (ProductVO productVO : productList) {
                BigDecimal unitPrice = productVO.getUnitPrice();
                Integer buyCount = productVO.getBuyCount();
                paymentAmount = paymentAmount.add(unitPrice.multiply(BigDecimal.valueOf(buyCount)));
            }
        }

        List<OrderMoneyVO> moneyList = new ArrayList<>();
        // 商品金额
        OrderMoneyVO productAmount = new OrderMoneyVO();
        productAmount.setMoneyType(OrderMoneyEnum.ORDER_AMOUNT.getType());
        productAmount.setMoneyName(OrderMoneyEnum.ORDER_AMOUNT.getTypeName());
        productAmount.setMoney(paymentAmount);
        productAmount.setMoneyStr(paymentAmount.setScale(2, RoundingMode.DOWN).toPlainString());
        productAmount.setSymbol(OrderMoneyEnum.ORDER_AMOUNT.getSymbol());
        productAmount.setCurrency(OrderMoneyEnum.ORDER_AMOUNT.getCurrency());
        productAmount.setSort(OrderMoneyEnum.ORDER_AMOUNT.getSort());

        // TODO 取运费
        // 运费
        OrderMoneyVO freightAmount = new OrderMoneyVO();
        freightAmount.setMoneyType(OrderMoneyEnum.FREIGHT_AMOUNT.getType());
        freightAmount.setMoneyName(OrderMoneyEnum.FREIGHT_AMOUNT.getTypeName());
        freightAmount.setMoney(BigDecimal.ZERO);
        freightAmount.setMoneyStr(BigDecimal.ZERO.setScale(2, RoundingMode.DOWN).toPlainString());
        freightAmount.setSymbol(OrderMoneyEnum.FREIGHT_AMOUNT.getSymbol());
        freightAmount.setCurrency(OrderMoneyEnum.FREIGHT_AMOUNT.getCurrency());
        freightAmount.setSort(OrderMoneyEnum.FREIGHT_AMOUNT.getSort());

        moneyList.add(productAmount);
        moneyList.add(freightAmount);
        confirmOrderVO.setMoneyList(moneyList);
    }

    @Override
    public void assemblyOrderDetailMoney(OrderDetailVO orderDetailVO) {
        OrderParamDTO orderParamDTO = orderDetailVO.getOrderItem().getOrderParamDTO();
        HxhOrderEntity orderInfo = orderParamDTO.getOrderInfo();

        OrderMoneyVO orderAmount = new OrderMoneyVO(
                OrderMoneyEnum.ORDER_AMOUNT.getType(),
                OrderMoneyEnum.ORDER_AMOUNT.getTypeName(),
                orderInfo.getOrderAmount(),
                orderInfo.getOrderAmount().toPlainString(),
                OrderMoneyEnum.ORDER_AMOUNT.getSymbol(),
                OrderMoneyEnum.ORDER_AMOUNT.getCurrency(),
                OrderMoneyEnum.ORDER_AMOUNT.getSort()
        );

        OrderMoneyVO freightAmount = new OrderMoneyVO(
                OrderMoneyEnum.FREIGHT_AMOUNT.getType(),
                OrderMoneyEnum.FREIGHT_AMOUNT.getTypeName(),
                orderInfo.getOrderAmount(),
                orderInfo.getOrderAmount().toPlainString(),
                OrderMoneyEnum.FREIGHT_AMOUNT.getSymbol(),
                OrderMoneyEnum.FREIGHT_AMOUNT.getCurrency(),
                OrderMoneyEnum.FREIGHT_AMOUNT.getSort()
        );

        List<OrderMoneyVO> moneyList = new ArrayList<>();
        moneyList.add(orderAmount);
        moneyList.add(freightAmount);
        orderDetailVO.setMoneyList(moneyList.stream().sorted(Comparator.comparing(OrderMoneyVO::getSort)).collect(Collectors.toList()));
    }

    @Override
    public void assemblyOrderDetailBelowList(OrderDetailVO orderDetailVO) {
        OrderParamDTO orderParamDTO = orderDetailVO.getOrderItem().getOrderParamDTO();
        HxhOrderEntity orderInfo = orderParamDTO.getOrderInfo();
        // 订单编号
        OrderBelowVO orderNo = new OrderBelowVO(
                OrderBelowEnum.ORDER_NO.getType(),
                OrderBelowEnum.ORDER_NO.getTypeName(),
                orderInfo.getOrderNo(),
                OrderBelowEnum.ORDER_NO.getAction(),
                OrderBelowEnum.ORDER_NO.getSort());
        // 下单时间
        OrderBelowVO createTime = new OrderBelowVO(
                OrderBelowEnum.CREATE_TIME.getType(),
                OrderBelowEnum.CREATE_TIME.getTypeName(),
                DateUtils.formatLocalDateTime(orderInfo.getCreateTime()),
                OrderBelowEnum.CREATE_TIME.getSort(),
                OrderBelowEnum.CREATE_TIME.getAction());
        // 订单备注
        OrderBelowVO note = new OrderBelowVO(
                OrderBelowEnum.NOTE.getType(),
                OrderBelowEnum.NOTE.getTypeName(),
                orderInfo.getNote(),
                OrderBelowEnum.NOTE.getSort(),
                OrderBelowEnum.NOTE.getAction());
        // 支付时间
        OrderBelowVO payTime = new OrderBelowVO(
                OrderBelowEnum.PAY_TIME.getType(),
                OrderBelowEnum.PAY_TIME.getTypeName(),
                DateUtils.formatLocalDateTime(orderInfo.getPayTime()),
                OrderBelowEnum.PAY_TIME.getSort(),
                OrderBelowEnum.PAY_TIME.getAction());
        // 支付方式
        OrderBelowVO payPattern = new OrderBelowVO(
                OrderBelowEnum.PAY_PATTERN.getType(),
                OrderBelowEnum.PAY_PATTERN.getTypeName(),
                Optional.ofNullable(PayPatternEnums.getEnumByPayPattern(orderInfo.getPayPattern())).orElse(PayPatternEnums.UNKNOWN).getPayName(),
                OrderBelowEnum.PAY_PATTERN.getSort(),
                OrderBelowEnum.PAY_PATTERN.getAction());
        // 发货时间
        OrderBelowVO deliveryTime = new OrderBelowVO(
                OrderBelowEnum.DELIVERY_TIME.getType(),
                OrderBelowEnum.DELIVERY_TIME.getTypeName(),
                DateUtils.formatLocalDateTime(orderInfo.getDeliveryTime()),
                OrderBelowEnum.DELIVERY_TIME.getSort(),
                OrderBelowEnum.DELIVERY_TIME.getAction());
        // 收货时间
        OrderBelowVO receiveTime = new OrderBelowVO(
                OrderBelowEnum.RECEIVE_TIME.getType(),
                OrderBelowEnum.RECEIVE_TIME.getTypeName(),
                DateUtils.formatLocalDateTime(orderInfo.getReceiveTime()),
                OrderBelowEnum.RECEIVE_TIME.getSort(),
                OrderBelowEnum.RECEIVE_TIME.getAction());
        // 取消时间
        OrderBelowVO cancelTime = new OrderBelowVO(
                OrderBelowEnum.CANCEL_TIME.getType(),
                OrderBelowEnum.CANCEL_TIME.getTypeName(),
                DateUtils.formatLocalDateTime(orderInfo.getReceiveTime()),
                OrderBelowEnum.CANCEL_TIME.getSort(),
                OrderBelowEnum.CANCEL_TIME.getAction());
        List<OrderBelowVO> belowList = new ArrayList<>();
        belowList.add(orderNo);
        belowList.add(createTime);
        belowList.add(note);
        if (OrderPayStatusEnum.PAY.getType().equals(orderInfo.getPayStatus())) {
            if (StringUtils.isNotBlank(orderInfo.getPayPattern())) {
                belowList.add(payPattern);
            }
            belowList.add(payTime);
        }
        Integer orderStatus = orderInfo.getOrderStatus();
        OrderStatusEnum orderStatusEnums = OrderStatusEnum.getEnumByType(orderStatus);
        switch (Objects.requireNonNull(orderStatusEnums)) {
            case WAIT_ACCEPT:
                belowList.add(deliveryTime);
                break;
            case RECEIVED:
            case COMPLETED:
                belowList.add(deliveryTime);
                belowList.add(receiveTime);
                break;
            case CLOSE_DEAL:
                belowList.add(cancelTime);
                break;
            default:
                break;
        }
        orderDetailVO.setBelowList(belowList.stream().sorted(Comparator.comparing(OrderBelowVO::getSort)).collect(Collectors.toList()));
    }

    @Override
    public void assemblyOrderBtn(OrderItemVO orderItemVO) {
        HxhOrderEntity orderInfo = orderItemVO.getOrderParamDTO().getOrderInfo();
        // 订单按钮
        List<OrderButtonVO> buttonList = orderItemVO.getButtonList();
        Integer orderStatus = orderInfo.getOrderStatus();
        OrderStatusEnum orderStatusEnums = OrderStatusEnum.getEnumByType(orderStatus);
        switch (Objects.requireNonNull(orderStatusEnums)) {
            case WAIT_PAY:
                buttonList.add(OrderBtnConstant.CANCEL_ORDER);
                buttonList.add(OrderBtnConstant.PAY_IMMEDIATELY);
                break;
            case WAIT_SEND:
                buttonList.add(OrderBtnConstant.APPLY_REFUND);
                buttonList.add(OrderBtnConstant.MORE_ORDER);
                break;
            case WAIT_ACCEPT:
                buttonList.add(OrderBtnConstant.APPLY_REFUND);
                buttonList.add(OrderBtnConstant.CONFIRM_RECEIPT);
                buttonList.add(OrderBtnConstant.MORE_ORDER);
                break;
            case RECEIVED:
                buttonList.add(OrderBtnConstant.APPLY_REFUND);
                buttonList.add(OrderBtnConstant.MORE_ORDER);
                break;
            case COMPLETED:
            case CLOSE_DEAL:
                buttonList.add(OrderBtnConstant.MORE_ORDER);
                break;
            default:
                break;
        }

        orderItemVO.setButtonList(buttonList.stream().sorted(Comparator.comparing(OrderButtonVO::getSort)).collect(Collectors.toList()));
    }

    /**
     * 根据订单信息组装订单基本信息
     */
    @Override
    protected OrderItemVO assemblyOrderItemVO(HxhOrderEntity orderEntity,
                                              List<HxhOrderDetailEntity> orderDetailEntityList,
                                              List<HxhMaterialEntity> materialList) {
        Map<String, HxhMaterialEntity> skuMap = materialList.stream().collect(Collectors.toMap(HxhMaterialEntity::getSkuCode, item -> item));
        List<OrderProductVO> productVOList = new ArrayList<>();
        List<HxhMaterialEntity> currentOrderMaterialList = new ArrayList<>();
        Integer buyTotal = 0;
        //该订单系表信息
        for (HxhOrderDetailEntity orderDetail : orderDetailEntityList) {
            OrderProductVO orderProductVO = new OrderProductVO();
            String skuCode = orderDetail.getSkuCode();
            HxhMaterialEntity hxhMaterialEntity = skuMap.get(skuCode);
            currentOrderMaterialList.add(hxhMaterialEntity);
            HxhMaterialEntity materialEntity = skuMap.get(skuCode);
            orderProductVO.setSpuCode(materialEntity.getSpuCode());
            orderProductVO.setSkuCode(materialEntity.getSkuCode());
            orderProductVO.setMaterial(materialEntity.getMaterial());
            orderProductVO.setUnit(materialEntity.getUnit());
            orderProductVO.setPicPath(materialEntity.getPicPath());
            orderProductVO.setMilliliter(materialEntity.getMilliliter());
            orderProductVO.setTaste(materialEntity.getTaste());
            orderProductVO.setSpecification(materialEntity.getSpecification());
            orderProductVO.setUnitPrice(materialEntity.getUnitPrice());
            productVOList.add(orderProductVO);
            buyTotal += orderDetail.getBuyNum();
        }
        // 当前订单基本信息 数据传输对象
        OrderParamDTO orderParamDTO = new OrderParamDTO();
        orderParamDTO.setOrderInfo(orderEntity);
        orderParamDTO.setOrderDetailList(orderDetailEntityList);
        orderParamDTO.setMaterialList(currentOrderMaterialList);

        // 对外显示订单显示基本信息
        OrderItemVO orderItemVO = new OrderItemVO();
        orderItemVO.setOrderNo(orderEntity.getOrderNo());
        orderItemVO.setCreateTime(DateUtils.formatLocalDateTime(orderEntity.getCreateTime()));
        orderItemVO.setCornerLabel(new OrderLabelVO());
        orderItemVO.setProductList(productVOList);
        orderItemVO.setKindTotal(productVOList.size());
        orderItemVO.setCountTotal(buyTotal);
        orderItemVO.setPayAmount(orderEntity.getPayAmount().setScale(2, RoundingMode.DOWN).toPlainString());
        orderItemVO.setButtonList(new ArrayList<>());
        orderItemVO.setOrderParamDTO(orderParamDTO);
        return orderItemVO;
    }


    @Transactional(rollbackFor = Exception.class)
    protected List<String> createOrder(HxhOrderEntity hxhOrderEntity, List<HxhOrderDetailEntity> orderDetailList) {
        int i = hxhOrderMapper.insert(hxhOrderEntity);
        if (i < 0) {
            throw new AppException(OrderMessageConstant.CREATE_ORDER_ERROR);
        }
        int j = hxhOrderDetailMapper.insertBatch(orderDetailList);
        if (i < 0) {
            throw new AppException(OrderMessageConstant.CREATE_ORDER_ERROR);
        }
        List<String> orderNoList = new ArrayList<>();
        orderNoList.add(hxhOrderEntity.getOrderNo());
        return orderNoList;
    }

    /**
     * 对商详下单进行组装插入数据
     */
    public final OrderParamDTO buildOrderEntity(OrderCommitReq orderCommitReq) {
        List<StoreProductVO> storeProductList = orderCommitReq.getStoreProductList();
        ReceivedAddressVO receivedAddress = orderCommitReq.getReceivedAddress();

        StoreProductVO storeProductVO = storeProductList.get(0);
        StoreVO store = storeProductVO.getStore();
        List<ProductVO> productList = storeProductVO.getProductList();
        ProductVO productVO = productList.get(0);
        HxhMaterialEntity hxhMaterialEntityDB = commonProductService.getMaterialBySku(productVO.getSkuCode());
        if (hxhMaterialEntityDB.getOnShelf().equals(0)) {
            throw new AppException(ProductMessageConstant.PRODUCT_ON_SHELFED);
        }
        OrderParamDTO orderParamDTO = new OrderParamDTO();
        UserInfo userInfo = Authentication.getUserInfo();
        String orderNo = OrderUtils.createOrderNo();

        // TODO 如果加营销 在此 计算 优惠券 活动金额，积分花费等
        HxhOrderEntity hxhOrderEntity = new HxhOrderEntity();
        hxhOrderEntity.setOrderNo(orderNo);
        hxhOrderEntity.setOrderStatus(OrderStatusEnum.WAIT_PAY.getType());
        hxhOrderEntity.setBuyerCode(userInfo.getUnionId());
        hxhOrderEntity.setContacts(receivedAddress.getContacts());
        hxhOrderEntity.setTelephone(receivedAddress.getTelephone());
        hxhOrderEntity.setStoreId(store.getId());
        hxhOrderEntity.setPlatformSource(userInfo.getPlatformSource());
        hxhOrderEntity.setPayPattern(orderCommitReq.getPayPattern());
        hxhOrderEntity.setPayStatus(0);
        hxhOrderEntity.setOrderAmount(productVO.getUnitPrice().multiply(BigDecimal.valueOf(productVO.getBuyCount())));
        hxhOrderEntity.setDiscountAmount(BigDecimal.ZERO);
        hxhOrderEntity.setPayAmount(productVO.getUnitPrice().multiply(BigDecimal.valueOf(productVO.getBuyCount())));
        hxhOrderEntity.setFreightAmount(BigDecimal.ZERO);
        hxhOrderEntity.setCreateTime(LocalDateTime.now());
        hxhOrderEntity.setAddressId(receivedAddress.getId());
        hxhOrderEntity.setProvinceCode(receivedAddress.getProvinceCode());
        hxhOrderEntity.setProvinceName(receivedAddress.getProvinceName());
        hxhOrderEntity.setCityCode(receivedAddress.getCityCode());
        hxhOrderEntity.setCityName(receivedAddress.getCityName());
        hxhOrderEntity.setCountyCode(receivedAddress.getCountyCode());
        hxhOrderEntity.setCountyName(receivedAddress.getCountyName());
        hxhOrderEntity.setMapPosition(receivedAddress.getMapPosition());
        hxhOrderEntity.setAddress(receivedAddress.getAddress());
        hxhOrderEntity.setInvoice(0);
        hxhOrderEntity.setInvoiceChange(0);
        hxhOrderEntity.setEvaluation(0);
        hxhOrderEntity.setCommission(0);
        hxhOrderEntity.setFreezeDate(0);
        hxhOrderEntity.setRightsProtection(0);
        hxhOrderEntity.setOrderType(0);
        hxhOrderEntity.setNote(orderCommitReq.getNote());
        hxhOrderEntity.setDiscountDetails("");
        hxhOrderEntity.setCouponAmount(BigDecimal.ZERO);
        hxhOrderEntity.setActivityAmount(BigDecimal.ZERO);
        hxhOrderEntity.setPointAmount(BigDecimal.ZERO);
        hxhOrderEntity.setPointExpend(0);
        hxhOrderEntity.setCancelNote("");
        hxhOrderEntity.setCancelBy("");
        hxhOrderEntity.setIsDeleted(0);
        hxhOrderEntity.setOperBy("");
        hxhOrderEntity.setOperTime(LocalDateTime.now());

        List<HxhOrderDetailEntity> orderDetailList = new ArrayList<>();
        HxhOrderDetailEntity hxhOrderDetailEntity = new HxhOrderDetailEntity();
        hxhOrderDetailEntity.setOrderNo(orderNo);
        hxhOrderDetailEntity.setItemNo(1);
        hxhOrderDetailEntity.setProductStatus(OrderStatusEnum.WAIT_PAY.getType());
        hxhOrderDetailEntity.setStoreId(store.getId());
        hxhOrderDetailEntity.setSpuCode(productVO.getSpuCode());
        hxhOrderDetailEntity.setSkuCode(productVO.getSkuCode());
        hxhOrderDetailEntity.setMaterialCode(productVO.getMaterialCode());
        hxhOrderDetailEntity.setUnit(productVO.getUnit());
        hxhOrderDetailEntity.setUnitPrice(productVO.getUnitPrice());
        hxhOrderDetailEntity.setBuyNum(productVO.getBuyCount());
        hxhOrderDetailEntity.setProductAmount(productVO.getUnitPrice().multiply(BigDecimal.valueOf(productVO.getBuyCount())));
        hxhOrderDetailEntity.setDiscountAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setFreightAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setPayAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setRefundAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setDeliverNum(0);
        hxhOrderDetailEntity.setReceiveNum(0);
        hxhOrderDetailEntity.setRefundNum(0);
        hxhOrderDetailEntity.setRefundTimes(0);
        hxhOrderDetailEntity.setRefuseTimes(0);
        hxhOrderDetailEntity.setProductType(0);
        hxhOrderDetailEntity.setDiscountDetails("");
        hxhOrderDetailEntity.setCouponAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setActivityAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setPointAmount(BigDecimal.ZERO);
        hxhOrderDetailEntity.setPointExpend(0);
        hxhOrderDetailEntity.setShareId(orderCommitReq.getShareId());
        hxhOrderDetailEntity.setOperTime(LocalDateTime.now());
        orderDetailList.add(hxhOrderDetailEntity);
        orderParamDTO.setOrderInfo(hxhOrderEntity);
        orderParamDTO.setOrderDetailList(orderDetailList);
        return orderParamDTO;
    }

}
