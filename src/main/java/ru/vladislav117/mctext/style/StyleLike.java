package ru.vladislav117.mctext.style;

import net.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.jcolor.colorspace.RGBColorSpaceHolder;

public interface StyleLike extends Cloneable {
    /**
     * Получение значения компонента "полужирный".
     *
     * @return Значение компонента или null, если компонент не задан.
     */
    default @Nullable Boolean getBold() {
        return null;
    }

    /**
     * Установка значения компонента "полужирный".
     *
     * @param bold Значение компонента или null, чтобы сделать компонент незаданным.
     * @return Этот же стиль.
     */
    @SuppressWarnings("UnusedReturnValue")
    default StyleLike setBold(@Nullable Boolean bold) {
        return this;
    }

    /**
     * Получение значения компонента "курсив".
     *
     * @return Значение компонента или null, если компонент не задан.
     */
    default @Nullable Boolean getItalic() {
        return null;
    }

    /**
     * Установка значения компонента "курсив".
     *
     * @param italic Значение компонента или null, чтобы сделать компонент незаданным.
     * @return Этот же стиль.
     */
    @SuppressWarnings("UnusedReturnValue")
    default StyleLike setItalic(@Nullable Boolean italic) {
        return this;
    }

    /**
     * Получение значения компонента "подчёркнутый".
     *
     * @return Значение компонента или null, если компонент не задан.
     */
    default @Nullable Boolean getUnderlined() {
        return null;
    }

    /**
     * Установка значения компонента "подчёркнутый".
     *
     * @param underlined Значение компонента или null, чтобы сделать компонент незаданным.
     * @return Этот же стиль.
     */
    @SuppressWarnings("UnusedReturnValue")
    default StyleLike setUnderlined(@Nullable Boolean underlined) {
        return this;
    }

    /**
     * Получение значения компонента "перечёркнутый" ("зачёркнутый").
     *
     * @return Значение компонента или null, если компонент не задан.
     */
    default @Nullable Boolean getStrikethrough() {
        return null;
    }

    /**
     * Установка значения компонента "перечёркнутый" ("зачёркнутый").
     *
     * @param strikethrough Значение компонента или null, чтобы сделать компонент незаданным.
     * @return Этот же стиль.
     */
    @SuppressWarnings("UnusedReturnValue")
    default StyleLike setStrikethrough(@Nullable Boolean strikethrough) {
        return this;
    }

    /**
     * Получение значения компонента "запутанный" ("магический").
     *
     * @return Значение компонента или null, если компонент не задан.
     */
    default @Nullable Boolean getObfuscated() {
        return null;
    }

    /**
     * Установка значения компонента "запутанный" ("магический").
     *
     * @param obfuscated Значение компонента или null, чтобы сделать компонент незаданным.
     * @return Этот же стиль.
     */
    @SuppressWarnings("UnusedReturnValue")
    default StyleLike setObfuscated(@Nullable Boolean obfuscated) {
        return null;
    }

    /**
     * Получение цвета стиля.
     *
     * @return Цвет стиля или null, если цвет не задан.
     */
    default @Nullable RGBColorSpaceHolder getColor() {
        return null;
    }

    /**
     * Установка цвета стиля.
     *
     * @param color Цвет стиля или null, чтобы сделать цвет незаданным.
     * @return Этот же стиль.
     */
    @SuppressWarnings("UnusedReturnValue")
    default StyleLike setColor(@Nullable RGBColorSpaceHolder color) {
        return this;
    }

    /**
     * Копирование стиля текста.
     *
     * @return Скопированный стиль текста.
     */
    StyleLike clone();

    /**
     * Преобразование объекта к стилю текста.
     *
     * @return Стиль текста.
     */
    Style toStyle();
}
