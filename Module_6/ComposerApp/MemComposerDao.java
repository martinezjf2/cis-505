package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {

    private List<Composer> composers;

    public MemComposerDao() {
        composers = new ArrayList<>();
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    @Override
    public List<Composer> findAll() {
        return new ArrayList<>(composers);
    }

    @Override
    public Composer findBy(Integer key) {
        for (Composer c : composers) {
            if (c.getId() == key) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void insert(Composer entity) {
        composers.add(entity);
    }
}