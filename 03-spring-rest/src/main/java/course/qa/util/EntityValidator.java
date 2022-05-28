package course.qa.util;

import course.qa.spring.exception.InvalidEntityDataException;

public interface EntityValidator<E> {
    void validate(E entity) throws InvalidEntityDataException;
}
