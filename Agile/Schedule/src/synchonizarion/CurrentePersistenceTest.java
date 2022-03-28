package synchonizarion;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.repository.ContactRepository;
import com.at.internship.schedule.repository.SingletonRepository;

import java.io.IOException;
import java.time.LocalDate;

import static com.at.internship.schedule.repository.SingletonRepository.*;

public class CurrentePersistenceTest {
    public static void main(String[] args) {
        ContactCreator contactCreator = new ContactCreator();
        ContactCreatorDos contactCreator1 = new ContactCreatorDos();
        Thread t1 = new Thread(contactCreator);
        Thread t2 = new Thread(contactCreator1);
        t1.start();
        t2.start();
        Thread t3 = new Thread(contactCreator);
        Thread t4 = new Thread(contactCreator1);
        t3.start();
        t4.start();
    }

    static class ContactCreator implements Runnable{
        private final ContactRepository contactRepository;
        public ContactCreator(){
            contactRepository = (ContactRepository) SingletonRepository.getSingleton(KEY_CONTACT_REPOSITORY);
        }

        @Override
        public void run() {
            try {
                Contact tomas = new Contact();
                tomas.setFirstName("Tomas");
                tomas.setLastName("Gomez");
                tomas.setPhoneNumber("5555555555");
                tomas.setEmailAddress("tGomez@gmail.com");
                tomas.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact miguel = new Contact();
                miguel.setFirstName("Miguel");
                miguel.setLastName("Hernandez");
                miguel.setPhoneNumber("5555555551");
                miguel.setEmailAddress("mHernandes@gmail.com");
                miguel.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact teresa = new Contact();
                teresa.setFirstName("Teresa");
                teresa.setLastName("Hernandez");
                teresa.setPhoneNumber("5555555551");
                teresa.setEmailAddress("ternandes@gmail.com");
                teresa.setBirthDay(LocalDate.parse("1994-04-18"));
                contactRepository.save(tomas);
                contactRepository.save(miguel);
                contactRepository.save(teresa);

            }catch (IOException e){
                System.out.println("There were problems when persisting contacts");
            }
        }
    }

    static class ContactCreatorDos implements Runnable {
        private final ContactRepository contactRepository;

        public ContactCreatorDos() {
            contactRepository = (ContactRepository) SingletonRepository.getSingleton(KEY_CONTACT_REPOSITORY);
        }

        @Override
        public void run() {
            try {
                Contact tomas = new Contact();
                tomas.setFirstName("Vicente");
                tomas.setLastName("Gomez");
                tomas.setPhoneNumber("5555555555");
                tomas.setEmailAddress("tGomez@gmail.com");
                tomas.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact miguel = new Contact();
                miguel.setFirstName("Javier");
                miguel.setLastName("Hernandez");
                miguel.setPhoneNumber("5555555551");
                miguel.setEmailAddress("mHernandes@gmail.com");
                miguel.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact teresa = new Contact();
                teresa.setFirstName("Norma");
                teresa.setLastName("Hernandez");
                teresa.setPhoneNumber("5555555551");
                teresa.setEmailAddress("ternandes@gmail.com");
                teresa.setBirthDay(LocalDate.parse("1994-04-18"));
                contactRepository.save(tomas);
                contactRepository.save(miguel);
                contactRepository.save(teresa);

            } catch (IOException e) {
                System.out.println("There were problems when persisting contacts");
            }
        }
    }
}
