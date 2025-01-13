package interfaces;

import forpeople.Blood;
import forpeople.Tools;
import people.Babka;
import people.Person;

public interface Hit {
    void hit(Babka b, Blood blood, Person.Costume costume, Tools tools);
}
