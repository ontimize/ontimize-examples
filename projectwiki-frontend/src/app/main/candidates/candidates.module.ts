import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CandidatesRoutingModule } from './candidates-routing.module';
import { CandidatesHomeComponent } from './home/candidates-home.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { CandidatesNewComponent } from './new/candidates-new.component';
import { CandidatesDetailComponent } from './detail/candidates-detail.component';


@NgModule({
  declarations: [CandidatesHomeComponent, CandidatesNewComponent, CandidatesDetailComponent],
  imports: [
    CommonModule,
    CandidatesRoutingModule,
    OntimizeWebModule
  ]
})
export class CandidatesModule { }
