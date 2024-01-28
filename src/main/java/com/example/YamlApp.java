package com.example;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.example.yaml.Contact;
import com.example.yaml.Customer;

public class YamlApp {
    
    public static void main(String[] args) {
        
        // LoaderOptions loaderOptions = new LoaderOptions();
        // TagInspector tagInspector = tag -> tag.getClassName().equals(Customer.class.getName());
        // loaderOptions.setTagInspector(tagInspector);

        // loadCustomerWithGenericContact();

        loadAllCustomers();
    }

    public static void loadCustomerWithContactDetailsAndAddress() {
        
        Yaml yaml = new Yaml(new Constructor(Customer.class, new LoaderOptions()));
        InputStream inputStream = yaml.getClass().getClassLoader().getResourceAsStream("customer_with_contact_details_and_address.yaml");
        Customer customer = yaml.load(inputStream);

        System.out.println(customer);
    }

    public static void loadCustomerWithGenericContact() {

        Constructor constructor = new Constructor(Customer.class, new LoaderOptions());
        TypeDescription customTypeDescription = new TypeDescription(Customer.class);
        customTypeDescription.addPropertyParameters("contactDetails", Contact.class);
        constructor.addTypeDescription(customTypeDescription);

        Yaml yaml = new Yaml(constructor);
        InputStream inputStream = yaml.getClass().getClassLoader().getResourceAsStream("customer_with_contact_details_generic_and_address.yaml");
        Customer customer = yaml.load(inputStream);

        System.out.println(customer);
    }

    public static void loadAllCustomers() {

        Yaml yaml = new Yaml();
        InputStream inputStream = yaml.getClass().getClassLoader().getResourceAsStream("visiting_address.yaml");

        Map<String, Object> map = yaml.load(inputStream);
        String address = (String) map.get("visiting_address");
        System.out.println(address);
    }
}
