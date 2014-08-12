package com.hotel_c.poisoncraft.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class Accessor {
    /**
     * gets the method object in the given object with the given name
     * @param clazz the class of the object
     * @param name the name of the method
     * @return the method
     * @throws NoSuchMethodException
     */
    public static Method getMethod(Class<?> clazz, String name) throws NoSuchMethodException {
        return clazz.getDeclaredMethod(name);
    }

    /**
     * gets the field object in the given object with the given name
     * @param clazz the class of the object
     * @param name the name of the field
     * @return the field
     * @throws NoSuchFieldException
     */
    public static Field getField(Class<?> clazz, String name) throws NoSuchFieldException {
        return clazz.getDeclaredField(name);
    }

    /**
     * sets a field accessible
     * @param field the field to be accessed
     */
    public static void access(Field field) {
        field.setAccessible(true);
    }

    /**
     * sets a method accessible
     * @param method the method to be accessed
     */
    public static void access(Method method) {
        method.setAccessible(true);
    }

    /**
     * invokes the given method in the given object
     * @param method the method to be invoked
     * @param instance the object containing the method
     * @return whatever the invoked method returns
     * @throws Exception
     */
    public static Object invoke(Method method, Object instance) throws Exception {
        return method.invoke(instance);
    }
}
