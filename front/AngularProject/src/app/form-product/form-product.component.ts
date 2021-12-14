import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Product } from '../model/product';

@Component({
  selector: 'app-form-product',
  templateUrl: './form-product.component.html',
  styleUrls: ['./form-product.component.css']
})
export class FormProductComponent implements OnInit {
  form : FormGroup;
  private product: Product;

  @Output() addEvent = new EventEmitter<Product>()
  @Input() updateProduct : Product;
  constructor(private builder : FormBuilder,private toast:ToastrService,private toastr:ToastrService) { }

  ngOnInit(): void {
    if (this.updateProduct === null){
      this.product = new Product();
    } else {
      this.product = this.updateProduct;
    }

    this.form = this.builder.group({
      'title' : [this.product.title, [Validators.required, Validators.minLength(5)]],
      'description' : [this.product.description, Validators.required],
      'price' : [this.product.price, [Validators.required, Validators.min(10)]],
      'picture' : [this.product.picture, Validators.required],
      'category' : [this.product.category, Validators.required],
      'quantity' : [this.product.quantity, [Validators.required, Validators.min(0)]]
    });
  }
  
  addProduct(form : FormGroup){
    this.product.title       = form.value.title;
    this.product.description = form.value.description;
    this.product.price       = form.value.price;
    this.product.picture     = form.value.picture;
    this.product.quantity    = form.value.quantity;

    this.addEvent.emit(this.product);
    this.toastr.warning('produits ajouté','nouveaux produit!')

  }

}
