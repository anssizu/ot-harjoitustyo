/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anssizu.fitnesstracker;

/**
 *
 * @author anselmusheino
 */
public class User {
    
    private int totalExerciseKcals;

    public int getTotalExerciseKcals() {
        return totalExerciseKcals;
    }

    public void addTotalExerciseKcals(int amount) {
        if (amount <= 0) return;
        this.totalExerciseKcals += amount;
    }
    
    
}
