import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  build: { //add this property
    sourcemap: true,
  },
  resolve: {
    alias: {
      '@' : path.resolve(__dirname, 'src'),
      '@router' : path.join(__dirname, 'src/router'),
      '@components' : path.join(__dirname, 'src/components'),
      '@layouts' : path.join(__dirname, 'src/layouts'),
      '@pages' : path.join(__dirname, 'src/pages'),
      '@slice' : path.join(__dirname, 'src/slice'),
      '@api' : path.join(__dirname, 'src/api'),
      '@hooks' : path.join(__dirname, 'src/hooks'),
      '@util' : path.join(__dirname, 'src/util'),
    }
  },
})
