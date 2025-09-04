package ru.vladislav117.mctext;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mctext.style.StyleLike;

import java.util.Collection;

/**
 * Интерфейс, экземпляры реализаций которого могут быть текстом.
 */
public interface TextLike extends Cloneable {
    /**
     * Получение стиля текста.
     *
     * @return Стиль текста или null, если стиль не задан.
     */
    default @Nullable StyleLike getStyle() {
        return null;
    }

    /**
     * Установка стиля текста.
     *
     * @param style Стиль текста или null, чтобы сделать стиль незаданным
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike setStyle(@Nullable StyleLike style) {
        return this;
    }

    /**
     * Отправить этот текст как сообщение.
     *
     * @param audience Получатель или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike sendMessage(@Nullable Audience audience) {
        if (audience != null) audience.sendMessage(toComponent());
        return this;
    }

    /**
     * Отправить этот текст как сообщение.
     *
     * @param audiences Получатели или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike sendMessage(@Nullable Collection<@Nullable Audience> audiences) {
        if (audiences == null) return this;
        Component component = toComponent();
        for (Audience audience : audiences) {
            if (audience != null) audience.sendMessage(component);
        }
        return this;
    }

    /**
     * Отправить этот текст как сообщение.
     *
     * @param audiences Получатели или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike sendMessage(@Nullable Audience[] audiences) {
        if (audiences == null) return this;
        Component component = toComponent();
        for (Audience audience : audiences) {
            if (audience != null) audience.sendMessage(component);
        }
        return this;
    }

    /**
     * Отправить этот текст как сообщение для хотбара.
     *
     * @param audience Получатель или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike sendActionBar(@Nullable Audience audience) {
        if (audience != null) audience.sendActionBar(toComponent());
        return this;
    }

    /**
     * Отправить этот текст как сообщение для хотбара.
     *
     * @param audiences Получатели или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike sendActionBar(@Nullable Collection<@Nullable Audience> audiences) {
        if (audiences == null) return this;
        Component component = toComponent();
        for (Audience audience : audiences) {
            if (audience != null) audience.sendActionBar(component);
        }
        return this;
    }

    /**
     * Отправить этот текст как сообщение для хотбара.
     *
     * @param audiences Получатели или null
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    default TextLike sendActionBar(@Nullable Audience[] audiences) {
        if (audiences == null) return this;
        Component component = toComponent();
        for (Audience audience : audiences) {
            if (audience != null) audience.sendActionBar(component);
        }
        return this;
    }

    /**
     * Создание контейнера и добавление этого текста внутрь.
     *
     * @return Созданный контейнер.
     */
    default TextContainer toContainer() {
        return new TextContainer(this);
    }

    /**
     * Создание контейнера и добавление копии этого текста внутрь.
     *
     * @return Созданный контейнер.
     */
    default TextContainer toContainerCopy() {
        return new TextContainer(clone());
    }

    /**
     * Замена подстроки на строку.
     *
     * @param from Подстрока, которая будет заменена
     * @param to   Строка, на которую будет произведена замена
     * @return Этот же текст.
     */
    @SuppressWarnings("UnusedReturnValue")
    TextLike replace(String from, String to);

    /**
     * Копирование текста.
     *
     * @return Скопированный текст.
     */
    TextLike clone();

    /**
     * Преобразование этого текста к компоненту.
     *
     * @return Компонент.
     */
    Component toComponent();
}
