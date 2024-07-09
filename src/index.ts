import { registerPlugin } from '@capacitor/core';

import type { CheckMockLocationPlugin } from './definitions';

const CheckMockLocation = registerPlugin<CheckMockLocationPlugin>('CheckMockLocation', {
  web: () => import('./web').then(m => new m.CheckMockLocationWeb()),
});

export * from './definitions';
export { CheckMockLocation };
