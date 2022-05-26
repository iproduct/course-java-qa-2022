package course.qa.util;

import course.java.exception.ConstraintViolationException;

public interface EntityValidator<E> {
    void validate(E entity) throws ConstraintViolationException;
}
