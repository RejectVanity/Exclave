#!/bin/bash

source "bin/init/env.sh"
source "bin/plugin/shadowtls/build.sh"

DIR="$ROOT/x86_64"
mkdir -p $DIR

export CC=$ANDROID_X86_64_CC
export CXX=$ANDROID_X86_64_CXX
export RUST_ANDROID_GRADLE_CC=$ANDROID_X86_64_CC
export CARGO_TARGET_X86_64_LINUX_ANDROID_LINKER=$PROJECT/bin/rust-linker/linker-wrapper.sh

rustup override set nightly-2023-12-13
cargo build --release -p shadow-tls --target x86_64-linux-android
cp target/x86_64-linux-android/release/shadow-tls $DIR/$LIB_OUTPUT
