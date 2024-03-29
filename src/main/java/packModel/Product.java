package packModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements IbaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;

    @Formula(value = "(case when (taxType='PRODUCT') then (price*0.23) when (taxType='SERVICE') then (price*0.08) end)")
    private double tax;

    @Enumerated(value = EnumType.STRING)
    private TaxType taxType;

    private int stock;

    @ToString.Exclude
    @ManyToOne()
    private Invoice invoice;
}
