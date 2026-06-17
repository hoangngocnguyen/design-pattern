package baithi;

public class OrderStateFactory {
    
    public static OrderState getState(String statusText) {
        if (statusText == null) return new DraftState();
        
        return switch (statusText.toUpperCase()) {
            case "DRAFT" -> new DraftState();
            case "CONFIRMED" -> new ConfirmedState();
            case "SHIPPING" -> new ShippingState();
            case "DELIVERED" -> new DeliveredState();
            case "CANCELLED" -> new CanceledState();
            default -> new DraftState();
        };
    }
}