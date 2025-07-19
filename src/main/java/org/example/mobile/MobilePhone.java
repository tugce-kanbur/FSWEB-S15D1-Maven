package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

import org.example.mobile.Contact;


public class MobilePhone {
    public String myNumber;
    public ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = (ArrayList<Contact>) myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }
    public boolean addNewContact(Contact contact){
        if(myContacts.contains(contact)){
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }
    }
    public boolean updateContact(Contact eski, Contact yeni){
        int pozisyon = findContact(eski);
        if(pozisyon < 0){
            return false;
        }
        int yeniPozisyon = findContact(yeni.getName());
        if(yeniPozisyon != -1 && yeniPozisyon != pozisyon){
            return false;
        }
        myContacts.set(pozisyon,yeni);
        return true;
    }
    public boolean removeContact(Contact contact){
        if(!myContacts.contains(contact)){
            return false;
        }else{
            myContacts.remove(contact);
            return true;
        }
    }
    public int findContact(Contact contact){
            return myContacts.indexOf(contact);
    }
    public int findContact(String name){
        for (int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        for(Contact contact : myContacts){
            if(contact.getName().equals(name)){
               return contact;
            }
        }
        return null;
    }
    public void printContact(){
        System.out.println("Contact List: ");
        for(int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + "-> " + contact.getPhoneNumber());
        }
    }
}
