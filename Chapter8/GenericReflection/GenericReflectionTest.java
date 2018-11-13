package com.CoreJava.Chapter8.GenericReflection;

import java.lang.reflect.*;
import java.util.*;

/**
* @Description:
* @param:
* @return:
* @author: Leslie Chan
* @Date: 2018-06-24
*/

public class GenericReflectionTest {
    public static void main(String[] args) {
        //read class name from command line args or user input
        String name;
        if (args.length > 0)
            name = args[0];
        else
        {
            try (Scanner in = new Scanner(System.in))
            {
                System.out.println("Enter class name (e.g. java.util.Collection):");
                name = in.next();
            }
        }

        try {
            //print generic info for class and public methods
            Class<?> c1 = Class.forName(name);
            printClass(c1);
            for (Method method : c1.getDeclaredMethods())
                printMethod(method);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static void printClass(Class<?> c1)
    {
        System.out.print(c1);
        printTypes(c1.getTypeParameters(), "<", ",", ">", true);
        Type sc = c1.getGenericSuperclass();
        if (sc != null)
        {
            System.out.print(" extends ");
            printType(sc, false);
        }
        printTypes(c1.getGenericInterfaces(), "implements", ",", "", false);
        System.out.println();
    }
    public static void printMethod(Method m)
    {
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(), " <", ",", "> ", true);

    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition)
    {
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[] {Object.class}))
            return;
        if (types.length > 0)
            System.out.print(pre);
        for (int i = 0; i < types.length; i++)
        {
            if (i > 0)
                System.out.print(sep);
            printType(types[i], isDefinition);
        }
        if (types.length > 0)
            System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition)
    {
        if (type instanceof  Class)
        {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }
        else if (type instanceof TypeVariable)
        {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition)
                printTypes(t.getBounds(), "extends", "&", "", false);
        }
        else if (type instanceof WildcardType)
        {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        }
        else if (type instanceof ParameterizedType)
        {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null)
            {
                printType(owner, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ",", ">", false);
        }
        else if (type instanceof GenericArrayType)
        {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}
