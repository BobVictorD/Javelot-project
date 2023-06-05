import { DonneeMeteoDto } from "./donnees-meteo-dto";

export interface VilleDto {
    nom: string;
    latitude: number;
    longitude: number;
    releveMeteos: DonneeMeteoDto[];
}