import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button'; // Button
import { MatDividerModule } from '@angular/material/divider'; // Divider
import { MatIconModule } from '@angular/material/icon'; // Icon
import { MatCardModule } from '@angular/material/card'; // Card
import { MatProgressBarModule } from '@angular/material/progress-bar'; // Progress Bar
import { MatToolbarModule } from '@angular/material/toolbar'; // Toolbar
import { MatTableModule } from '@angular/material/table'; // Table

const MATERIAL_MODULES = [
  MatButtonModule,
  MatDividerModule,
  MatIconModule,
  MatCardModule,
  MatProgressBarModule,
  MatToolbarModule,
  MatTableModule
];

@NgModule({
  imports: [MATERIAL_MODULES],
  exports: [MATERIAL_MODULES],
})
export class MaterialModule {}
