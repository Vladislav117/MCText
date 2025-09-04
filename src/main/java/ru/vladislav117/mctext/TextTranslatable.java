package ru.vladislav117.mctext;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.Translatable;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mctext.style.StyleLike;

/**
 * Текст с ключом перевода.
 */
public class TextTranslatable extends Text {
    protected String translationKey;

    /**
     * Создание текста с ключом перевода.
     *
     * @param translationKey Ключ перевода
     * @param style          Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextTranslatable(String translationKey, @Nullable StyleLike style) {
        this.translationKey = translationKey;
        this.style = style;
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translationKey Ключ перевода
     */
    public TextTranslatable(String translationKey) {
        this.translationKey = translationKey;
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translatable Переводимый объект
     * @param style        Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextTranslatable(Translatable translatable, @Nullable StyleLike style) {
        translationKey = translatable.translationKey();
        this.style = style;
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translatable Переводимый объект
     */
    public TextTranslatable(Translatable translatable) {
        translationKey = translatable.translationKey();
    }

    /**
     * Копирование текста с ключом перевода.
     *
     * @param text Текст с ключом перевода
     */
    public TextTranslatable(TextTranslatable text) {
        translationKey = text.translationKey;
        if (text.style != null) style = text.style.clone();
    }

    @Override
    public TextTranslatable clone() {
        return new TextTranslatable(this);
    }

    /**
     * Получение ключа перевода.
     *
     * @return Ключ перевода.
     */
    public String getTranslationKey() {
        return translationKey;
    }

    /**
     * Установка ключа перевода.
     *
     * @param translationKey Ключ перевода
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextTranslatable setTranslationKey(String translationKey) {
        this.translationKey = translationKey;
        return this;
    }

    /**
     * Установка ключа перевода.
     *
     * @param translatable Переводимый объект
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextTranslatable setTranslationKey(Translatable translatable) {
        translationKey = translatable.translationKey();
        return this;
    }

    @Override
    public Component toComponent() {
        Component component = Component.translatable(translationKey);
        if (style != null) component = component.style(style.toStyle());
        return component;
    }

    @Override
    public TextLike replace(String from, String to) {
        return this;
    }
}
