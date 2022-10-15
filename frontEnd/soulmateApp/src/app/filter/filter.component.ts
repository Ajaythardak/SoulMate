import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'custom-search-filter-example';
  searchedKeyword!: string;

  filterResultDataSet = [
    {
      firstName: 'Cristiano',
      lastName: 'Ronaldo',
      country: 'Pourtgal',
      club:'Juventus'
    },
    {
      firstName: 'Leo',
      lastName: 'Messi',
      country: 'Argentina',
      club:'Barcelona'
    },
    {
      firstName: 'Neymar',
      lastName: 'Junior',
      country: 'BRAZIL',
      club:'PSG'
    },
    {
      firstName: 'Sergio',
      lastName: 'Ramos',
      country: 'SPAIN',
      club:'Real Madrid'
    },
    {
      firstName: 'Karim',
      lastName: 'Benzema',
      country: 'France',
      club:'Real Madrid'
    },
    {
      firstName: 'Sergio',
      lastName: 'Buiscut',
      country: 'SPAIN',
      club:'Barcelona'
    },
    {
      firstName: 'Gerard',
      lastName: 'Pique',
      country: 'SPAIN',
      club:'Barcelona'
    }
  ]
}

