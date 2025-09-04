package ru.vladislav117.mctext;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.Translatable;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mctext.style.StyleLike;

import java.util.Collection;

/**
 * Абстрактный текст.
 */
public abstract class Text implements TextLike {
    protected @Nullable StyleLike style = null;

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable Collection<TextLike> texts, @Nullable StyleLike style) {
        return new TextContainer(texts, style);
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable TextLike[] texts, @Nullable StyleLike style) {
        return new TextContainer(texts, style);
    }

    /**
     * Создание текста-контейнера.
     *
     * @param text  Текст или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable TextLike text, @Nullable StyleLike style) {
        return new TextContainer(text, style);
    }

    /**
     * Создание пустого текста-контейнера.
     *
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable StyleLike style) {
        return new TextContainer(style);
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable Collection<TextLike> texts) {
        return new TextContainer(texts);
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable TextLike[] texts) {
        return new TextContainer(texts);
    }

    /**
     * Создание текста-контейнера.
     *
     * @param text Текст или null, если контейнер пустой
     * @return Текст-контейнер.
     */
    public static TextContainer container(@Nullable TextLike text) {
        return new TextContainer(text);
    }

    /**
     * Создание пустого текста-контейнера.
     *
     * @return Текст-контейнер.
     */
    public static TextContainer container() {
        return new TextContainer();
    }

    /**
     * Создание строкового текста. Если в качестве объекта будет передано null, то будет взята null-строка.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     * @param style  Стиль текста или null, чтобы сделать стиль незаданным
     * @return Строковый текст.
     */
    public static TextString string(@Nullable Object object, @Nullable StyleLike style) {
        return new TextString(object, style);
    }

    /**
     * Создание строкового текста. Если в качестве объекта будет передано null, то будет взята null-строка.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     * @return Строковый текст.
     */
    public static TextString string(@Nullable Object object) {
        return new TextString(object);
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translationKey Ключ перевода
     * @param style          Стиль текста или null, чтобы сделать стиль незаданным
     * @return Текст с ключом перевода.
     */
    public static TextTranslatable translatable(String translationKey, @Nullable StyleLike style) {
        return new TextTranslatable(translationKey, style);
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translationKey Ключ перевода
     * @return Текст с ключом перевода.
     */
    public static TextTranslatable translatable(String translationKey) {
        return new TextTranslatable(translationKey);
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translatable Переводимый объект
     * @param style        Стиль текста или null, чтобы сделать стиль незаданным
     * @return Текст с ключом перевода.
     */
    public static TextTranslatable translatable(Translatable translatable, @Nullable StyleLike style) {
        return new TextTranslatable(translatable, style);
    }

    /**
     * Создание текста с ключом перевода.
     *
     * @param translatable Переводимый объект
     * @return Текст с ключом перевода.
     */
    public static TextTranslatable translatable(Translatable translatable) {
        return new TextTranslatable(translatable);
    }

    /**
     * Создание текста с компонентом.
     *
     * @param component Компонент
     * @param style     Стиль или null, чтобы сделать стиль незаданным
     * @return Текст с компонентом.
     */
    public static TextComponent component(Component component, @Nullable StyleLike style) {
        return new TextComponent(component, style);
    }

    /**
     * Создание текста с компонентом.
     *
     * @param component Компонент
     * @return Текст с компонентом.
     */
    public static TextComponent component(Component component) {
        return new TextComponent(component);
    }

    @Override
    public @Nullable StyleLike getStyle() {
        return style;
    }

    @Override
    public TextLike setStyle(@Nullable StyleLike style) {
        this.style = style;
        return this;
    }

    @Override
    public abstract TextLike replace(String from, String to);

    @Override
    public abstract Text clone();
}
