import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { CustomPermissionsService } from './services/custom-permissions.service';

@NgModule({
  imports: [
    OntimizeWebModule
  ],
  declarations: [
  ],
  exports: [
    CommonModule
  ],
  providers: [
    CustomPermissionsService
  ]
})
export class SharedModule { }
