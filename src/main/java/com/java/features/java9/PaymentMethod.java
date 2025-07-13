package com.java.features.java9;

/**
 * Sealed class introduced in java 17, it provide a way to control which classes or interfaces can
 * extend or implement a particular class or interface
 * This feature allows developers to define a restricted class hierarchy , making it easier to manage and
 * reason about inheritance in large or complex codebase.
 * To make a class or interface as sealed , you have to use sealed modifier followed by permit clause that lists
 * the classes allowed to extend it.
 * <p>
 * public sealed class Shape permits Circle, Rectangle, Triangle{
 * class body
 * }
 * <p>
 * Only classes or interfaces mentioned in the permits clause can extends or implement the sealed class/interface.
 * These subclasses can themselves be either final , non-sealed or sealed
 * <p>
 * public final class Circle extends Shape{
 * <p>
 * }
 * <p>
 * public sealed class Polygon extends Shape permits Square, Pentagon{
 * <p>
 * }
 * <p>
 * public non-sealed class Rectangle extends Shape{
 * <p>
 * }
 **/


public abstract sealed class PaymentMethod permits CreditCard, BankTransfer, OnlineWallet {
    public abstract void processPayment(PaymentMethod method);
}
