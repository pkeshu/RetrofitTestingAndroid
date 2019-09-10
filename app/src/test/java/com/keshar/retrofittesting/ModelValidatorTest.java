package com.keshar.retrofittesting;

import org.junit.Test;

public class ModelValidatorTest {

    public static final String NAME = "keshar";

    @Test()
    public void shouldNotThrowErrorOnValidCharacterModel() throws IllegalArgumentException {
        CharacterModelBuilder builder = new CharacterModelBuilder();
        builder.setName(NAME);

        CharectersModel characterModel = builder.build();

        ModelValidator validator = new ModelValidator(characterModel);
        validator.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorOnInvalidCharacterModel() throws IllegalArgumentException {
        CharacterModelBuilder builder = new CharacterModelBuilder();
        builder.setName(null);

        CharectersModel characterModel = builder.build();

        ModelValidator validator = new ModelValidator(characterModel);
        validator.validate();
    }
}