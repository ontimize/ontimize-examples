import { NgModule } from '@angular/core';
import { ServiceWorkerModule } from '@angular/service-worker';
import { APP_CONFIG, ONTIMIZE_MODULES, ONTIMIZE_PROVIDERS, O_PERMISSION_SERVICE, OntimizeWebModule } from 'ontimize-web-ngx';

import { environment } from '../environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CONFIG } from './app.config';
import { CustomPermissionsService } from './shared/services/custom-permissions.service';

// Standard providers...
// Defining custom providers (if needed)...
export const customProviders: any = [
];

@NgModule({
  imports: [
    ONTIMIZE_MODULES,
    OntimizeWebModule,
    AppRoutingModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [
    AppComponent
  ],
  providers: [
    { provide: APP_CONFIG, useValue: CONFIG },
    ONTIMIZE_PROVIDERS,
    { provide: O_PERMISSION_SERVICE, useValue: CustomPermissionsService },
    ...customProviders
  ],
})
export class AppModule { }
