import { Injectable } from '@angular/core';
import { Facture } from '../model/facture.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FactureService {
  apiURL: string = 'http://localhost:8081/SpringMVC/servlet/getAllFactures';
  apiURL2: string = 'http://localhost:8081/SpringMVC/servlet/add-facture';
  apiURL3: string = ' http://localhost:8081/SpringMVC/servlet/remove-facture/';
  apiURL4: string = 'http://localhost:8081/SpringMVC/servlet/updatefacture';
  apiURL5: string = ' http://localhost:8081/SpringMVC/servlet/retrieve-facture/';




  factures?: Facture[]; //un tableau de chînes de caractères
  facture?: Facture;

  constructor(private http: HttpClient) {
  }

  listeFacture(): Observable<Facture[]> {
    return this.http.get<Facture[]>(this.apiURL);
  }

  ajouterFacture(prod: Facture): Observable<Facture> {
    return this.http.post<Facture>(this.apiURL2, prod, httpOptions);
  }

  deleteFacture(id: number) {
    const url = `${this.apiURL3}/${id}`;
    return this.http.delete(url, httpOptions);
  }

  consulterFacture(id:number): Observable<Facture> {
    return this.http.get<Facture>(this.apiURL5+id);
    
  }

  updateFacture(prod: Facture): Observable<Facture> {
    return this.http.put<Facture>(this.apiURL4, prod, httpOptions);
  }

  trierFactures() {
    this.factures = this.factures!.sort((n1, n2) => {
      if (n1.montantFacture > n2.montantFacture) {
        return 1;
      }
      if (n1.montantFacture< n2.montantFacture) {
        return -1;
      }
      return 0;
    });
  }


}
