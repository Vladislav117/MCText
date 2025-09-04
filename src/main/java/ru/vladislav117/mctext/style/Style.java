package ru.vladislav117.mctext.style;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.jcolor.colorspace.RGBColorSpaceHolder;

/**
 * Стиль текста.
 */
public class Style implements StyleLike {
    protected @Nullable Boolean bold = null;
    protected @Nullable Boolean italic = null;
    protected @Nullable Boolean underlined = null;
    protected @Nullable Boolean strikethrough = null;
    protected @Nullable Boolean obfuscated = null;
    protected @Nullable RGBColorSpaceHolder color = null;

    /**
     * Создание нового стиля.
     *
     * @param bold          Значение компонента стиля "полужирный", или null, чтобы сделать компонент незаданным
     * @param italic        Значение компонента стиля "курсив", или null, чтобы сделать компонент незаданным
     * @param underlined    Значение компонента стиля "подчёркнутый", или null, чтобы сделать компонент незаданным
     * @param strikethrough Значение компонента стиля "перечёркнутый" ("зачёркнутый"), или null, чтобы сделать компонент незаданным
     * @param obfuscated    Значение компонента стиля "запутанный" ("магический"), или null, чтобы сделать компонент незаданным
     * @param color         Цвет стиля, или null, чтобы сделать цвет незаданным
     */
    public Style(@Nullable Boolean bold, @Nullable Boolean italic, @Nullable Boolean underlined, @Nullable Boolean strikethrough, @Nullable Boolean obfuscated, @Nullable RGBColorSpaceHolder color) {
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
        this.obfuscated = obfuscated;
        this.color = color;
    }

    /**
     * Создание нового стиля.
     *
     * @param bold          Значение компонента стиля "полужирный", или null, чтобы сделать компонент незаданным
     * @param italic        Значение компонента стиля "курсив", или null, чтобы сделать компонент незаданным
     * @param underlined    Значение компонента стиля "подчёркнутый", или null, чтобы сделать компонент незаданным
     * @param strikethrough Значение компонента стиля "перечёркнутый" ("зачёркнутый"), или null, чтобы сделать компонент незаданным
     * @param obfuscated    Значение компонента стиля "запутанный" ("магический"), или null, чтобы сделать компонент незаданным
     */
    public Style(@Nullable Boolean bold, @Nullable Boolean italic, @Nullable Boolean underlined, @Nullable Boolean strikethrough, @Nullable Boolean obfuscated) {
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
        this.obfuscated = obfuscated;
    }

    /**
     * Создание нового стиля.
     *
     * @param color Цвет стиля, или null, чтобы сделать цвет незаданным
     */
    public Style(@Nullable RGBColorSpaceHolder color) {
        this.color = color;
    }

    /**
     * Копирование стиля.
     *
     * @param style Стиль, который будет скопирован.
     */
    public Style(Style style) {
        bold = style.bold;
        italic = style.italic;
        underlined = style.underlined;
        strikethrough = style.strikethrough;
        obfuscated = style.obfuscated;
        if (style.color != null) color = style.color.clone();
    }

    /**
     * Создание пустого стиля.
     */
    public Style() {
    }

    /**
     * Создание пустого стиля.
     *
     * @return Созданный стиль.
     */
    public static Style newEmpty() {
        return new Style();
    }

    /**
     * Создание стиля с заданным компонентом стиля "полужирный".
     *
     * @param bold Значение компонента стиля, или null, чтобы сделать компонент незаданным
     * @return Созданный стиль.
     */
    public static Style newBold(@Nullable Boolean bold) {
        return new Style().setBold(bold);
    }

    /**
     * Создание стиля с заданным компонентом стиля "полужирный" в значение true.
     *
     * @return Созданный стиль.
     */
    public static Style newBold() {
        return new Style().setBold(true);
    }

    /**
     * Создание стиля с заданным компонентом стиля "курсив".
     *
     * @param italic Значение компонента стиля, или null, чтобы сделать компонент незаданным
     * @return Созданный стиль.
     */
    public static Style newItalic(@Nullable Boolean italic) {
        return new Style().setItalic(italic);
    }

    /**
     * Создание стиля с заданным компонентом стиля "курсив" в значение true.
     *
     * @return Созданный стиль.
     */
    public static Style newItalic() {
        return new Style().setItalic(true);
    }

    /**
     * Создание стиля с заданным компонентом стиля "подчёркнутый".
     *
     * @param underlined Значение компонента стиля, или null, чтобы сделать компонент незаданным
     * @return Созданный стиль.
     */
    public static Style newUnderlined(@Nullable Boolean underlined) {
        return new Style().setUnderlined(underlined);
    }

    /**
     * Создание стиля с заданным компонентом стиля "подчёркнутый" в значение true.
     *
     * @return Созданный стиль.
     */
    public static Style newUnderlined() {
        return new Style().setUnderlined(true);
    }

    /**
     * Создание стиля с заданным компонентом стиля "перечёркнутый" ("зачёркнутый").
     *
     * @param strikethrough Значение компонента стиля, или null, чтобы сделать компонент незаданным
     * @return Созданный стиль.
     */
    public static Style newStrikethrough(@Nullable Boolean strikethrough) {
        return new Style().setStrikethrough(strikethrough);
    }

    /**
     * Создание стиля с заданным компонентом стиля "перечёркнутый" ("зачёркнутый") в значение true.
     *
     * @return Созданный стиль.
     */
    public static Style newStrikethrough() {
        return new Style().setStrikethrough(true);
    }

    /**
     * Создание стиля с заданным компонентом стиля "запутанный" ("магический").
     *
     * @param obfuscated Значение компонента стиля, или null, чтобы сделать компонент незаданным
     * @return Созданный стиль.
     */
    public static Style newObfuscated(@Nullable Boolean obfuscated) {
        return new Style().setObfuscated(obfuscated);
    }

    /**
     * Создание стиля с заданным компонентом стиля "запутанный" ("магический") в значение true.
     *
     * @return Созданный стиль.
     */
    public static Style newObfuscated() {
        return new Style().setObfuscated(true);
    }

    /**
     * Создание стиля с заданным цветом.
     *
     * @param color Цвет стиля, или null, чтобы сделать цвет незаданным
     * @return Созданный стиль.
     */
    public static Style newColor(@Nullable RGBColorSpaceHolder color) {
        return new Style(color);
    }

    @Override
    public Style clone() {
        try {
            Style style = (Style) super.clone();
            style.bold = bold;
            style.italic = italic;
            style.underlined = underlined;
            style.strikethrough = strikethrough;
            style.obfuscated = obfuscated;
            if (color != null) style.color = color.clone();
            return style;
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public @Nullable Boolean getBold() {
        return bold;
    }

    @Override
    public Style setBold(@Nullable Boolean bold) {
        this.bold = bold;
        return this;
    }

    @Override
    public @Nullable Boolean getItalic() {
        return italic;
    }

    @Override
    public Style setItalic(@Nullable Boolean italic) {
        this.italic = italic;
        return this;
    }

    @Override
    public @Nullable Boolean getUnderlined() {
        return underlined;
    }

    @Override
    public Style setUnderlined(@Nullable Boolean underlined) {
        this.underlined = underlined;
        return this;
    }

    @Override
    public @Nullable Boolean getStrikethrough() {
        return strikethrough;
    }

    @Override
    public Style setStrikethrough(@Nullable Boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    @Override
    public @Nullable Boolean getObfuscated() {
        return obfuscated;
    }

    @Override
    public Style setObfuscated(@Nullable Boolean obfuscated) {
        this.obfuscated = obfuscated;
        return this;
    }

    @Override
    public @Nullable RGBColorSpaceHolder getColor() {
        return color;
    }

    @Override
    public Style setColor(@Nullable RGBColorSpaceHolder color) {
        this.color = color;
        return this;
    }

    @Override
    public net.kyori.adventure.text.format.Style toStyle() {
        net.kyori.adventure.text.format.Style style = net.kyori.adventure.text.format.Style.empty();
        if (bold != null) style = style.decoration(TextDecoration.BOLD, bold);
        if (italic != null) style = style.decoration(TextDecoration.BOLD, italic);
        if (underlined != null) style = style.decoration(TextDecoration.BOLD, underlined);
        if (strikethrough != null) style = style.decoration(TextDecoration.BOLD, strikethrough);
        if (obfuscated != null) style = style.decoration(TextDecoration.BOLD, obfuscated);
        if (color != null) style = style.color(TextColor.color(color.getRGBInteger()));
        return style;
    }

    @Override
    public String toString() {
        String string = "{";
        if (bold != null) string += "bold=" + bold + ", ";
        if (italic != null) string += "italic=" + italic + ", ";
        if (underlined != null) string += "underlined=" + underlined + ", ";
        if (strikethrough != null) string += "strikethrough=" + strikethrough + ", ";
        if (obfuscated != null) string += "obfuscated=" + obfuscated + ", ";
        if (color != null) string += "color=" + color + ", ";
        if (string.endsWith(", ")) string = string.substring(0, string.length() - 2);
        string += "}";
        return string;
    }
}
