package ru.vladislav117.mctext;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.Translatable;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mctext.style.StyleLike;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Текст-контейнер, состоящий из других текстов.
 */
public class TextContainer extends Text {
    static TextLike defaultSpace = new TextString(" ");
    static TextLike defaultNewLine = new TextString("\n");

    protected List<TextLike> texts = new ArrayList<>();

    /**
     * Получение пробела по умолчанию.
     *
     * @return Пробел по умолчанию.
     */
    public static TextLike getDefaultSpace() {
        return defaultSpace;
    }

    /**
     * Установка пробела по умолчанию.
     *
     * @param defaultSpace Пробел по умолчанию
     */
    public static void setDefaultSpace(TextLike defaultSpace) {
        TextContainer.defaultSpace = defaultSpace;
    }

    /**
     * Получение переноса строки по умолчанию.
     *
     * @return Перенос строки по умолчанию.
     */
    public static TextLike getDefaultNewLine() {
        return defaultNewLine;
    }

    /**
     * Установка переноса строки по умолчанию.
     *
     * @param defaultNewLine Перенос строки по умолчанию
     */
    public static void setDefaultNewLine(TextLike defaultNewLine) {
        TextContainer.defaultNewLine = defaultNewLine;
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextContainer(@Nullable Collection<TextLike> texts, @Nullable StyleLike style) {
        if (texts != null) {
            for (TextLike text : texts) {
                if (text != null) this.texts.add(text);
            }
        }
        this.style = style;
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextContainer(@Nullable TextLike[] texts, @Nullable StyleLike style) {
        if (texts != null) {
            for (TextLike text : texts) {
                if (text != null) this.texts.add(text);
            }
        }
        this.style = style;
    }

    /**
     * Создание текста-контейнера.
     *
     * @param text  Текст или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextContainer(@Nullable TextLike text, @Nullable StyleLike style) {
        if (text != null) texts.add(text);
        this.style = style;
    }

    /**
     * Создание пустого текста-контейнера.
     *
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextContainer(@Nullable StyleLike style) {
        this.style = style;
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     */
    public TextContainer(@Nullable Collection<TextLike> texts) {
        if (texts != null) {
            for (TextLike text : texts) {
                if (text != null) this.texts.add(text);
            }
        }
    }

    /**
     * Создание текста-контейнера.
     *
     * @param texts Тексты или null, если контейнер пустой
     */
    public TextContainer(@Nullable TextLike[] texts) {
        if (texts != null) {
            for (TextLike text : texts) {
                if (text != null) this.texts.add(text);
            }
        }
    }

    /**
     * Создание текста-контейнера.
     *
     * @param text Текст или null, если контейнер пустой
     */
    public TextContainer(@Nullable TextLike text) {
        if (text != null) texts.add(text);
    }

    /**
     * Копирование текста-контейнера.
     *
     * @param text Текст, который будет скопирован
     */
    public TextContainer(TextContainer text) {
        for (TextLike innerText : text.texts) texts.add(innerText.clone());
        if (text.style != null) style = text.style.clone();
    }

    /**
     * Создание пустого текста-контейнера.
     */
    public TextContainer() {
    }

    @Override
    public Text clone() {
        return new TextContainer(this);
    }

    /**
     * Добавление текста в контейнер. Если стиль не null, то текст будет помещён в уникальный контейнер, к которому будет применён стиль.
     * Если текст равен null, то ничего не будет добавлено.
     *
     * @param text  Текст, который будет добавлен, или null
     * @param style Стиль или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addText(@Nullable TextLike text, @Nullable StyleLike style) {
        if (style != null) {
            if (text != null) texts.add(new TextContainer(text, style));
        } else {
            if (text != null) texts.add(text);
        }
        return this;
    }

    /**
     * Добавление текста в контейнер. Если стиль не null, то текст будет помещён в уникальный контейнер, к которому будет применён стиль.
     * Если текст равен null, то ничего не будет добавлено.
     *
     * @param text Текст, который будет добавлен, или null
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addText(@Nullable TextLike text) {
        if (text != null) texts.add(text);
        return this;
    }

    /**
     * Добавление контейнера в контейнер.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addContainer(@Nullable Collection<TextLike> texts, @Nullable StyleLike style) {
        this.texts.add(new TextContainer(texts, style));
        return this;
    }

    /**
     * Добавление контейнера в контейнер.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addContainer(@Nullable TextLike[] texts, @Nullable StyleLike style) {
        this.texts.add(new TextContainer(texts, style));
        return this;
    }

    /**
     * Добавление контейнера в контейнер.
     *
     * @param text  Текст или null, если контейнер пустой
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addContainer(@Nullable TextLike text, @Nullable StyleLike style) {
        texts.add(new TextContainer(text, style));
        return this;
    }

    /**
     * Добавление контейнера в контейнер.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addContainer(@Nullable Collection<TextLike> texts) {
        this.texts.add(new TextContainer(texts));
        return this;
    }

    /**
     * Добавление контейнера в контейнер.
     *
     * @param texts Тексты или null, если контейнер пустой
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addContainer(@Nullable TextLike[] texts) {
        this.texts.add(new TextContainer(texts));
        return this;
    }

    /**
     * Добавление контейнера в контейнер.
     *
     * @param text Текст или null, если контейнер пустой
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addContainer(@Nullable TextLike text) {
        texts.add(new TextContainer(text));
        return this;
    }

    /**
     * Добавление строки в контейнер.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     * @param style  Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addString(@Nullable Object object, @Nullable StyleLike style) {
        texts.add(new TextString(object, style));
        return this;
    }

    /**
     * Добавление строки в контейнер.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addString(@Nullable Object object) {
        texts.add(new TextString(object));
        return this;
    }

    /**
     * Добавление переводимого текста в контейнер.
     *
     * @param translationKey Ключ перевода
     * @param style          Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addTranslatable(String translationKey, @Nullable StyleLike style) {
        texts.add(new TextTranslatable(translationKey, style));
        return this;
    }

    /**
     * Добавление переводимого текста в контейнер.
     *
     * @param translationKey Ключ перевода
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addTranslatable(String translationKey) {
        texts.add(new TextTranslatable(translationKey));
        return this;
    }

    /**
     * Добавление переводимого текста в контейнер.
     *
     * @param translatable Переводимый объект
     * @param style        Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addTranslatable(Translatable translatable, @Nullable StyleLike style) {
        texts.add(new TextTranslatable(translatable, style));
        return this;
    }

    /**
     * Добавление переводимого текста в контейнер.
     *
     * @param translatable Переводимый объект
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addTranslatable(Translatable translatable) {
        texts.add(new TextTranslatable(translatable));
        return this;
    }

    /**
     * Добавление компонента в контейнер.
     *
     * @param component Компонент
     * @param style     Стиль или null, чтобы сделать стиль незаданным
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addComponent(Component component, @Nullable StyleLike style) {
        texts.add(new TextComponent(component, style));
        return this;
    }

    /**
     * Добавление компонента в контейнер.
     *
     * @param component Компонент
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addComponent(Component component) {
        texts.add(new TextComponent(component));
        return this;
    }

    /**
     * Добавление пробела в текст.
     *
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addSpace() {
        texts.add(defaultSpace);
        return this;
    }

    /**
     * Добавление пробела в текст.
     *
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer space() {
        return addSpace();
    }

    /**
     * Добавление пробела в текст.
     *
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer sp() {
        return addSpace();
    }

    /**
     * Добавление переноса строки в текст.
     *
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer addNewLine() {
        texts.add(defaultNewLine);
        return this;
    }

    /**
     * Добавление переноса строки в текст.
     *
     * @return Этот же контейнер.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextContainer newline() {
        return addNewLine();
    }

    /**
     * Добавление переноса строки в текст.
     *
     * @return Этот же контейнер.
     */
    public TextContainer nl() {
        return addNewLine();
    }

    @Override
    public Component toComponent() {
        Component component = Component.empty();
        for (TextLike text : texts) component = component.append(text.toComponent());
        if (style != null) component = component.style(style.toStyle());
        return component;
    }

    @Override
    public TextLike replace(String from, String to) {
        for (TextLike entry : texts) {
            entry.replace(from, to);
        }
        return this;
    }
}
