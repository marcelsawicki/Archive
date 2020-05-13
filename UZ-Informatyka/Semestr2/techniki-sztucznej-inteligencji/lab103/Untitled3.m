% Zaimplementuj algorytm przeszukiwania A*. Sprawd� dzia�anie algorytmu dla
% grafu zdefiniowanego jak w Listingu 1 Pliki seed.mat, map.bmp oraz
% mkaegraph.m znajduj� sie w archiwum z list� zada�

% czyszczenie przestrzeni roboczej, ekranu i okien
clc; clear; close all hidden; 

map = imread('map.bmp'); % wczytanie obrazka
imshow(map); % wyswietlenie mapy

load seed.mat; % wczytanie ziarna rng

map = map+map.*rand(20); %losowa zmiana warto�ci pikseli

[A,H] = makegraph(map); % utworzenie macierzy s�siedztwa oraz heurystyk H

path = astar(start, stop); % funkcja do zaimplementowania algorytmu A*