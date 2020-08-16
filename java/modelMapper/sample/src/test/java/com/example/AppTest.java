package com.example;

import com.example.domain.model.Address;
import com.example.domain.model.Customer;
import com.example.domain.model.Name;
import com.example.domain.model.Order;
import com.example.view.model.OrderDTO;

import org.modelmapper.ModelMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        Order order = Order
                .builder().customer(Customer.builder()
                        .name(Name.builder().firstName("firstName").lastName("lastName").build()).build())
                .billingAddress(Address.builder().street("street").city("city").build()).build();
        ModelMapper modelMapper = new ModelMapper();
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        // var typeMap = modelMapper.typeMap(Order.class, OrderDTO.class);
        // typeMap.addMapping(src -> src.getCustomer().getName(), OrderDTO::setCustomerFirstName);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
    }
}
