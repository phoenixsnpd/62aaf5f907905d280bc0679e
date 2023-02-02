package ua.ithillel.homework32.soap;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.ithillel.homework32.entity.Order;
import ua.ithillel.homework32.repository.OrderRepository;
import ua.ithillel.homework32.ws.gen.contract.FindAllOrdersResponse;
import ua.ithillel.homework32.ws.gen.contract.FindOrderByIdRequest;
import ua.ithillel.homework32.ws.gen.contract.FindOrderByIdResponse;

import java.util.Optional;

@RequiredArgsConstructor
@Endpoint
public class OrderEndpoint {
    private static final String NAMESPACE_URL = "http://www.ithillel.ua/springsoap/gen";

    private final OrderRepository orderRepository;

    @PayloadRoot(localPart = "findAllOrdersRequest", namespace = NAMESPACE_URL)
    @ResponsePayload
    public FindAllOrdersResponse findAll() {
        var response = new FindAllOrdersResponse();
        return response;
    }

    @PayloadRoot(localPart = "findOrderByIdRequest", namespace = NAMESPACE_URL)
    @ResponsePayload
    public FindOrderByIdResponse findByID(@RequestPayload FindOrderByIdRequest request) {
        Optional<Order> order = orderRepository.getOrderByID(request.getId());
        var response = new FindOrderByIdResponse();
        order.ifPresent(o ->{
            var dummyOrder = new Order();
            dummyOrder.setId(o.getId());
            dummyOrder.setDate(o.getDate());
            dummyOrder.setCost(o.getCost());
        });
        return response;
    }
}
