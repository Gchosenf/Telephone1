package com.gml.Client;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("联系人添加成功！");
    }

    public void showContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        System.out.println("联系人删除成功！");
    }

    // 新增修改联系人功能
    public void updateContact(String name, String newPhone, String newAddress) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                // 修改电话号码和住址
                contact.setPhone(newPhone);
                contact.setAddress(newAddress);
                System.out.println("联系人信息更新成功！");
                return;
            }
        }
        System.out.println("未找到联系人: " + name);
    }
}
