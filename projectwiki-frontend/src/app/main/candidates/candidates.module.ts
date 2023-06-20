import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CandidatesRoutingModule } from './candidates-routing.module';
import { CandidatesHomeComponent } from './home/candidates-home.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { CandidatesViewComponent } from './candidates-view/candidates-view.component';
import { OFileManagerModule } from 'ontimize-web-ngx-filemanager';


@NgModule({
  declarations: [CandidatesHomeComponent, CandidatesViewComponent],
  imports: [
    CommonModule,
    CandidatesRoutingModule,
    OntimizeWebModule,
    OFileManagerModule]
})
export class CandidatesModule { }
