package ru.vladislav117.mctext;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mctext.style.StyleLike;

/**
 * Текст, представляющий собой простую строку.
 */
public class TextString extends Text {
    static String defaultNullString = "null";
    protected String string;

    /**
     * Получение null-строки по умолчанию.
     *
     * @return Null-строка по умолчанию.
     */
    public static String getDefaultNullString() {
        return defaultNullString;
    }

    /**
     * Установка null-строки по умолчанию.
     *
     * @param defaultNullString Null-строка по умолчанию.
     */
    public static void setDefaultNullString(String defaultNullString) {
        TextString.defaultNullString = defaultNullString;
    }

    /**
     * Создание строкового текста. Если в качестве объекта будет передано null, то будет взята null-строка.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     * @param style  Стиль текста или null, чтобы сделать стиль незаданным
     */
    public TextString(@Nullable Object object, @Nullable StyleLike style) {
        if (object != null) {
            string = object.toString();
        } else {
            string = defaultNullString;
        }
        this.style = style;
    }

    /**
     * Создание строкового текста. Если в качестве объекта будет передано null, то будет взята null-строка.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     */
    public TextString(@Nullable Object object) {
        if (object != null) {
            string = object.toString();
        } else {
            string = defaultNullString;
        }
    }

    /**
     * Копирование строкового текста.
     *
     * @param text Строковый текст.
     */
    public TextString(TextString text) {
        string = text.string;
        if (text.style != null) style = text.style.clone();
    }

    @Override
    public TextString clone() {
        return new TextString(this);
    }

    /**
     * Получение строки текста.
     *
     * @return Строка.
     */
    public String getString() {
        return string;
    }

    /**
     * Установка строки текста. Если в качестве объекта будет передано null, то будет взята null-строка.
     *
     * @param object Объект, который будет преобразован в строку методом toString, или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextString setString(@Nullable Object object) {
        if (object != null) {
            string = object.toString();
        } else {
            string = defaultNullString;
        }
        return this;
    }

    @Override
    public Component toComponent() {
        Component component = Component.text(string);
        if (style != null) component = component.style(style.toStyle());
        return component;
    }

    @Override
    public TextLike replace(String from, String to) {
        string = string.replace(from, to);
        return this;
    }
}
