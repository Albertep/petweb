package tutorialweb.petweb.services.map;

import tutorialweb.petweb.Model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID > {

    protected Map<Long,T> map= new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object.getId()!=null){
                object.setId(getNextId());
        }
        map.put(object.getId(),object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }

    private Long getNextId(){

        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            return 1L;
        }

    }
}
