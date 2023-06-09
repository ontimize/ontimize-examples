import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CandidatesRoutingModule } from './candidates-routing.module';
import { CandidatesHomeComponent } from './home/candidates-home.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';


@NgModule({
  declarations: [CandidatesHomeComponent],
  imports: [
    CommonModule,
    CandidatesRoutingModule,
    OntimizeWebModule
  ]
})
export class CandidatesModule { }
