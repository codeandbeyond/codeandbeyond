package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class ParticleVelocity {
    public  int particleVelocity(int[] particles) {
        int totalCount = 0;
        for (int i = 0; i < particles.length; i++) {
            for (int count = 0; i + 2 < particles.length && particles[i + 1] - particles[i] == particles[i + 2] - particles[i + 1]; i++) {
                count++;
                totalCount += count;
            }
        }
        return totalCount < 1000000000 ? totalCount : -1;
    }

    public static void main(String[] args) {
        ParticleVelocity particleVelocity = new ParticleVelocity();
        int[] particles = {1, 3, 5, 7, 9};
        int res = particleVelocity.particleVelocity(particles);
        System.out.println(res);
    }
}
