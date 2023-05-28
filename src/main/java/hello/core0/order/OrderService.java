package hello.core0.order;

public interface OrderService {
    // 주문생성 : 회원id, 상품명, 가격 -> 파라미터로 넘김
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
