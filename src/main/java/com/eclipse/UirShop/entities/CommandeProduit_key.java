package com.eclipse.UirShop.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class CommandeProduit_key implements Serializable {



        Long Product_id;
        Long Order_id;


}
