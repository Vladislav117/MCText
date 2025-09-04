package ru.vladislav117.mctext;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mctext.style.StyleLike;

/**
 * Текст с компонентом.
 */
public class TextComponent extends Text {
    protected Component component;

    /**
     * Создание текста с компонентом.
     *
     * @param component Компонент
     * @param style     Стиль или null, чтобы сделать стиль незаданным
     */
    public TextComponent(Component component, @Nullable StyleLike style) {
        this.component = component;
        this.style = style;
    }

    /**
     * Создание текста с компонентом.
     *
     * @param component Компонент
     */
    public TextComponent(Component component) {
        this.component = component;
    }

    /**
     * Копирование текста с компонентом. Компонент не будет скопирован.
     *
     * @param text Текст с компонентом
     */
    public TextComponent(TextComponent text) {
        component = text.component;
        if (text.style != null) style = text.style.clone();
    }

    @Override
    public Text clone() {
        return new TextComponent(this);
    }

    /**
     * Получение компонента.
     *
     * @return Компонент.
     */
    public Component getComponent() {
        return component;
    }

    /**
     * Установка компонента.
     *
     * @param component Компонент
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    public TextComponent setComponent(Component component) {
        this.component = component;
        return this;
    }

    @Override
    public Component toComponent() {
        if (style != null) return Component.empty().append(component).style(style.toStyle());
        return component;
    }

    @Override
    public TextLike replace(String from, String to) {
        component = component.replaceText(TextReplacementConfig.builder().matchLiteral(from).replacement(to).build());
        return this;
    }
}
